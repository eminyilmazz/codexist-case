$(document).ready(function() {
    $('#findButton').click(fetchPlaces);
  });
  
  function fetchPlaces() {
    const longitude = $('#longitude').val();
    const latitude = $('#latitude').val();
    const radius = $('#radius').val();
  
    const url = `http://127.0.0.1:8070/get?long=${longitude}&lat=${latitude}&rad=${radius}`;
  
    $.ajax({
      url: url,
      type: 'GET',
      dataType: 'json',
      success: function(data) {
        displayPlaces(data);
      },
      error: function(xhr, status, error) {
        console.error('Error fetching nearby places:', error);
      }
    });
  }
  
  function displayPlaces(places) {
    const resultDiv = $('#result');
    resultDiv.empty();
  
    if (places && places.length > 0) {
      const ul = $('<ul></ul>');
      places.forEach(function(place) {
        const li = $('<li></li>').text(place.name);
        ul.append(li);
      });
      resultDiv.append(ul);
    } else {
      resultDiv.text('No nearby places found.');
    }
  }
  
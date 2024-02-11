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
        console.error('Error fetching:', error);
      }
    });
  }
  
  function displayPlaces(places) {
    const resultDiv = document.getElementById('result');
    resultDiv.innerHTML = '';

    $('#result').html(resultDiv);
    $('#result').show();

    if (places && places.length > 0) {
      const ul = document.createElement('ul');
      ul.classList.add('places-list');
  
      places.forEach(place => {
        const li = document.createElement('li');
        li.classList.add('place');
        
        const details = [];
        if (place.name) details.push(`<strong>Name:</strong> ${place.name}`);
        if (place.vicinity) details.push(`<strong>Vicinity:</strong> ${place.vicinity}`);
        if (place.rating !== null) details.push(`<strong>Rating:</strong> ${place.rating}`);
        if (place.user_ratings_total !== null) details.push(`<strong>User Ratings Total:</strong> ${place.user_ratings_total}`);
        if (place.price_level !== null) details.push(`<strong>Price Level:</strong> ${place.price_level}`);
        
        li.innerHTML = details.join('<br>');
        ul.appendChild(li);
        ul.appendChild(document.createElement('br'));
      });
  
      resultDiv.appendChild(ul);
    }
  }
  
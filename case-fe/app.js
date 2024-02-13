const app = Vue.createApp({
    data() {
      return {
        longitude: 'default_longitude_value',
        latitude: 'default_latitude_value',
        radius: 'default_radius_value',
        places: [],
        errorMessage: '',
        showResult: false,
        showError: false
      };
    },
    methods: {
      fetchPlaces() {
        const url = `http://127.0.0.1:8070/get?long=${this.longitude}&lat=${this.latitude}&rad=${this.radius}`;
        $.ajax({
          url: url,
          type: 'GET',
          dataType: 'json',
          success: (data, textStatus, xhr) => {
            if (xhr.status === 204) {
              this.handleError(xhr);
            } else {
              this.places = data;
              this.showError = false;
              this.showResult = true;
            }
          },
          error: (xhr, status, error) => {
            this.handleError(xhr);
          }
        });
      },
      handleError(xhr) {
        this.showError = true;
        this.showResult = false;
        const status = parseInt(xhr.status);
        const errorMessage = xhr.responseText;
        switch (status) {
          case 204:
            this.errorMessage = 'Search returned no results.';
            break;
          case 400:
          case 403:
          case 429:
          case 500:
            this.errorMessage = errorMessage;
            break;
          default:
            this.errorMessage = 'Error: ' + errorMessage;
            break;
        }
      }
    }
  });
  
  app.mount('#app');
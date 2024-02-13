const app = Vue.createApp({
    data() {
      return {
        longitude: '',
        latitude: '',
        radius: '',
        places: [],
        errorMessage: '',
        showResult: false,
        showError: false
      };
    },
    methods: {
      fetchPlaces() {
        if (!this.latitude || !this.longitude) {
            this.errorMessage = 'Longitude or latitude fields cannot be empty!';
            this.showError = true;
            this.showResult = false;
            return;
        }

        const url = `https://codexist-be-hqjbbnwqeq-ey.a.run.app/get?long=${this.longitude}&lat=${this.latitude}`;
        if (this.radius) {
            url = url + '&rad=${this.radius}';
        }

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
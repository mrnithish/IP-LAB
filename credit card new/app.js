const app = new Vue({ 
    el: '#app', 
    data: { 
    currentPage: 'registration', 
    isLoggedIn: false, 
    currentUser: {}, 
    registration: { 
    username: '', 
    password: '' 
    }, 
    login: { 
    username: '', 
    password: '' 
    }, 
    payment: { 
    cardNumber: '', 
    expiryDate: '', 
    cvv: '' 
    } 
    }, 
    methods: { 
    register() { 
    // Implement registration logic 
    console.log('Registration:', this.registration); 
    // You would typically send this data to the server for processing 
    }, 
    login() { 
    // Implement login logic 
                console.log('Login:', this.login); 
                // You would typically send this data to the server for authentication 
                // Set isLoggedIn and currentUser based on the server response 
                this.isLoggedIn = true; 
                this.currentUser = { username: this.login.username }; 
            }, 
            logout() { 
                // Implement logout logic 
                console.log('Logout'); 
                // You may also need to communicate with the server to invalidate the session 
                this.isLoggedIn = false; 
                this.currentUser = {}; 
            }, 
            makePayment() { 
                // Implement payment logic 
                console.log('Payment:', this.payment); 
                // You would typically send this data to the server for processing 
            } 
        } 
    }); 
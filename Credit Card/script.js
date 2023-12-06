// script.js

// Dummy user data for illustration
let currentUser = null;

function registerUser(event) {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    console.log('User registered:', username);
}

function loginUser(event) {
    event.preventDefault();
    const loginUsername = document.getElementById('login-username').value;
    const loginPassword = document.getElementById('login-password').value;

    console.log('User logged in:', loginUsername);

    currentUser = loginUsername;

    showUserProfile();
}

function showUserProfile() {
    document.querySelectorAll('.page').forEach(page => {
        page.style.display = 'none';
    });

    document.getElementById('profile-page').style.display = 'block';

    document.getElementById('user-greeting').innerText = `Welcome, ${currentUser}!`;
}

function processPayment(event) {
    event.preventDefault();
    const cardNumber = document.getElementById('card-number').value;
    const expiryDate = document.getElementById('expiry-date').value;

    console.log('Payment processed:', cardNumber, expiryDate);
}

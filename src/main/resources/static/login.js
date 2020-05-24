window.addEventListener("load", function(error) {

    if (isError()) {
        let result =  document.getElementById('result');
        result.innerText = 'Invalid credentials'
        result.style.color = 'red';
    }
});

function isError() {
    return window.location.search === '?error';
}
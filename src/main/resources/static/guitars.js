window.addEventListener("load", function () {

    document.getElementById('submit').addEventListener('click',
        function (e) {
            const url = "/guitars";
            e.preventDefault();
            const brand = document.getElementById('brand');
            const model = document.getElementById('model');
            const price = document.getElementById('price');

            const guitar = {
                "brand": brand.value,
                "model": model.value,
                "price": price.value
            };

            fetch(url, {
                method: 'POST',
                body: JSON.stringify(guitar),
                headers: {
                    'Content-Type': 'application/json'
                },
            }).then(response => {
                    const result = document.getElementById('result');
                    if (response.status >= 400) {
                        result.innerText =
                            response.status === 403 ? 'Unauthorized' : 'Unexpected exception';
                        result.style.color = 'red';
                    } else {
                        result.innerText = 'Guitar saved';
                        document.getElementById('createGuitar').reset();

                    }
                }
            )
        });
});
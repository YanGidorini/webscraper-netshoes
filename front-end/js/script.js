// Fetch API
function search(baseUrl, ref) {
    fetch(baseUrl + ref)
        .then(response => {
            if (!response.ok){
                throw new Error(response.status)
            }
            return response.json();
        })
        .then(data => {
            renderData(data)
        })
        .catch(error => { 
            if (error.message === "Failed to fetch") {
                renderError(error, "Falha na requisição")
            } else {
                renderError(error, "")
            }
            console.error("Ocorreu um erro:   " + error) 
        })
}

// Renderings
function renderData(data) {
    const product = document.querySelector(".product");
    const productCardHtml = 
    `
        <div class="product__card">
            <p class="product__title">${data.titulo}</p>
            <p class="product__price">R$ ${data.preco}</p>
            <figure class="product__figure">
                <img class="product__image" src="${data.urlImagem}">
            </figure>
            <p class="product__description-title">Descrição</p>
            <span class="product__description">${data.descricao}</span>
            
        </div>
    `
    product.innerHTML = productCardHtml;
}

function renderError(error, msg){
    const wrapper = document.querySelector(".wrapper")

    const el_errorDiv = document.createElement('div');
    el_errorDiv.classList.add("error");

    const el_errorMsg = document.createElement('p');
    el_errorMsg.classList.add("error__msg");
    el_errorMsg.textContent = error + msg;

    el_errorDiv.appendChild(el_errorMsg);
    wrapper.appendChild(el_errorDiv);
}

function unrenderData(){
    const product = document.querySelector(".product");
    product.innerHTML = "";
}

function unrenderError(){
    const errorElement = document.querySelector(".error")

    if (errorElement) {
        errorElement.remove();
    }
}


// Controller
const inputSearch = document.querySelector("#ref")
let delayTimer;

function send(event){
    const baseUrl = "http://localhost:8080/api/produto/"

    unrenderData();
    unrenderError();

    let ref = event.target.value.trim();
    if (ref === '') {return;}

    clearTimeout(delayTimer);
    delayTimer = setTimeout( () =>{
        search(baseUrl, ref)
    }, 300);
}

inputSearch.addEventListener('input', send);
# Web Scraper da Netshoes

Este projeto consiste em um web scraper do site da Netshoes, que disponibiliza uma API para acessar os dados coletados de um produto. 

## Estrutura do projeto

A pasta `back-end-api` contém o código-fonte do back-end, enquanto a pasta `front-end` contém o código que consome a API criada.

## Requisitos/configuração

- [x] [Instale o Java Development Kit (JDK) 18](https://www.oracle.com/java/technologies/javase/jdk18-archive-downloads.html)

- [x] [Configure as Variaveis de ambiente JAVA_HOME e JRE_HOME](https://confluence.atlassian.com/confbr1/configurando-a-variavel-java_home-no-windows-933709538.html)

## Execução
1. Clone este repositório em sua máquina.

2. Inicie o servidor da API: execute o seguinte comando no terminal, a partir da raiz da aplicação spring, que é a pasta: `back-end-api`

    ```bash
    ./mvnw spring-boot:run
    ```
    Quando a última linha for semelhante a que está abaixo, então o servidor estará em execução
    ```powershell
    2023-05-20T22:59:18.564-03:00  INFO 13076 --- [  restartedMain] c.n.api.WebscrapperNetshoesApplication   : SERVIDOR INICIADO
    ```
3. Acesse a pasta front-end e abra o arquivo X
4. Para parar a aplicação: `CRTL + C`, depois `s` e `enter`
   
## Realizando requisições
Caso queira utilizar a API, segue as instruções para uso:
1. Certifique-se de que o servidor da API está em execução. 
2. Abra um software para fazer requisições HTTP. Recomendo o postman, mas é possível fazer a requisição no navegador também.
3. Existe um único endpoint: `/api/produto/{ref}[GET]`, no qual `{ref}` é o código de referencia do produto
   - `{ref}` aceita valores em dois formatos:
     1. Somente o código. Ex.: 2I3-2126-006-03
     2. Nome do produto seguido do código. Ex.: agasalho-puma-poly-suit-cl-masculino-preto-2I3-2126-006
### Exemplo de requisição
***Observação:*** note que estou utilizando HTTP. Se tentar usar HTTPS para as requisições, obterá um erro

Passando o código
```bash
http://localhost:8080/api/produto/39W-3127-026-39
```
ou passando o nome do produto junto com o código
```bash
http://localhost:8080/api/produto/tenis-under-armour-basquete-spawn-3-masculino-cinza+amarelo-39W-3127-132
```

o resultado é o mesmo
```json
{
"titulo": "Tênis Under Armour Basquete Spawn 3 Masculino - Preto+Branco",
"preco": 294.49,
"urlImagem": "https://static.netshoes.com.br/produtos/tenis-under-armour-basquete-spawn-3-masculino/26/39W-3127-026/39W-3127-026_zoom1.jpg?ts=1657800556&ims=544x",
"descricao": "Dê o seu melhor nas quadras com o Tênis Under Armour Basquete Spawn 3 Masculino. Esse tênis conta com camadas moldadas entrelaçadas para design anatômico que oferece performance. O cabedal conta com estrutura firme e respirável, com suporte no calcanhar e tira de fácil calce para praticidade, tudo pensado na flexibilidade e estabilidade do jogador de basquete. Conta com entressola Cellfit para amortecimento macio e solado Micro G, que transforma cada pouso e impacto em decolagens explosivas. Aposte no design moderno e cheio de tecnologia desse tênis de basquete masculino e converta esse ponto!"
}
```
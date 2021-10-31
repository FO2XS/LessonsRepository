// получаем модуль Express
const express = require('express');
// создаем объект приложения
const app = express();

// определяем Router
const productRouter = express.Router();

// определяем маршруты и их обработчики внутри роутера
productRouter.use("/create", function(request, response){
response.send("Добавление товара");
});

productRouter.use("/:id", function(request, response){
response.send(`Товар ${request.params.id}`);
});

productRouter.use("/", function(request, response){
response.send("Список товаров");
});

// сопотавляем роутер с конечной точкой "/products"
app.use("/products", productRouter);

////
// создаем парсер для данных application/x-www-form-urlencoded
const urlencodedParser = express.urlencoded({ extended: false });

app.get("/", function (request, response) {
    response.sendFile(__dirname + "/index.html");
});

app.post("/", urlencodedParser, function (request, response) {
    if (!request.body)
        return response.sendStatus(400);
    console.log(request.body);

    response.send(`${request.body.userName} - ${request.body.userAge}`);
});

app.get("/products/:productId", function (request, response) {
    response.send("productId: " + request.params["productId"])
    });
////

app.get("/contact", function (request, response) {

    response.send("<h1>Контакты</h1>");

});

app.use("/home/foo/bar", function (request, response) {

    response.sendStatus(404);
});

app.use("/about", function (request, response) {

    let id = request.query.id;

    let userName = request.query.name;

    response.send("<h1>Информация</h1><p>id=" + id + "</p><p>name=" + userName + "</p>");
});

app.listen(8080, () => console.log("Сервер запущен..."));
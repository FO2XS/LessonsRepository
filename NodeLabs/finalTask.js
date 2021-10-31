const express = require("express");

const app = express();
const connection = require('./data/config');
const jsonParser = express.json();

/**
 * Добавляет нового пользователя системы.
 * Для добавления необходимо имя нового юзера.
 */
app.post("/owner", jsonParser, function (request, response) {
    console.log(request.body.userName);
    if (!request.body)
    {
        return response.sendStatus(400);
    }
    
    connection.query(`INSERT INTO owners (id, name) values (UUID(), '${request.body.userName}');`, (error, result) => {
        if (error) {
            response.send(error);
        };
        return response.json({success: true});
    });

});

/**
 * Возвращает список ценных бумаг, хранящихся в бд.
 */
app.get("/stocks", function (request, response) {

    connection.query('SELECT * FROM stocks', (error, result) => {
        if (error) {
            response.send(error);
        };

        response.send(result);
    });

});

/**
 * Возвращает форму ввода данных.
 */
app.get("/", function (request, response) {
    response.sendFile(__dirname + "/index.html");
});


app.listen(8080, () => console.log("Сервер запущен..."));
const mysql = require('mysql');

/**
 * Конфигурация подключения к бд.
 */
const config = {
    host: 'localhost',
    user: 'FOXXS',
    password: 'Obema1.',
    database: 'stock_market',
    port: 3306,
};

const connection = mysql.createConnection(config);

module.exports = connection;
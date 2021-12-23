package database;

import types.Tovar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PgProvider {

    public List<Tovar> getProducts()
    {
        List<Tovar> tovars = new ArrayList<Tovar>();
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/for_zemcov", "postgres", "admin");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT title, price, count FROM products");


            while (rs.next()) {
                Tovar temp = new Tovar();
                temp.setName(rs.getString("title"));
                temp.setPrice(rs.getInt("price"));
                temp.setKol(rs.getInt("count"));
                tovars.add(temp);
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return tovars;
    }

    public boolean authentication(String login, String password)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/for_zemcov", "postgres", "admin");
            PreparedStatement st = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE login = ? AND password = ?");
            st.setString(1, login);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();

            int result = 0;
            while (rs.next()) {
                result = rs.getInt(1);
            }
            System.out.println(result);
            return result == 1;
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean addProduct(Tovar tovar)
    {
        try {
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/for_zemcov", "postgres", "admin");

            PreparedStatement st = conn.prepareStatement("INSERT INTO products (title, count, price) VALUES (?, ?, ?)");
            st.setString(1, tovar.getName());
            st.setInt(2, tovar.getKol());
            st.setInt(3, tovar.getPrice());

            if(st.execute()){
                System.out.println("Успешно");
            }
            else {
                System.out.println("Неуспешно");
            }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}

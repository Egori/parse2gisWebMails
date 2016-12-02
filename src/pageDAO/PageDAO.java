package pageDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PageDAO {

    private final Connection con;

    public PageDAO(Connection con) {
        this.con = con;
    }

    //создание/обновление страницы в базе
    public void updatePage(Page page) {

        String category_1 = getCategory(page.getCategory_1());
        String category_2 = getCategory(page.getCategory_2());
        String category_3 = getCategory(page.getCategory_3());

        try {
            PreparedStatement ps;
            //если страница не новая
            if (page.getId() > 0) {
                ps = con.prepareStatement("UPDATE en SET company=?, email=?, region=?, federal_district=?, city=?, country=?, category_1=?, category_2=?, category_3=?, WHERE id=?");
                ps.setInt(11, page.getId());
                ps.setString(1, page.getCompanyName());
                ps.setString(2, page.getEmail());
                ps.setString(3, page.getRegion());
                ps.setString(4, page.getFederalDistrict());
                ps.setString(5, page.getCity());
                ps.setString(6, page.getCountry());
                ps.setString(7, category_1);
                ps.setString(8, category_2);
                ps.setString(9, category_3);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //создание страницы в базе
    public void insertPage(Page page) {

        String category_1 = getCategory(page.getCategory_1());
        String category_2 = getCategory(page.getCategory_2());
        String category_3 = getCategory(page.getCategory_3());

        try {
            PreparedStatement ps;
            ps = con.prepareStatement("INSERT INTO traderb2b_base_new (`company`, `email`, `region`, `federal_district`, `city`, `country`, `category_1`, `category_2`, `category_3`) VALUES (?,?,?,?,?,?,?,?,?)");

            ps.setString(1, page.getCompanyName());
            ps.setString(2, page.getEmail());
            ps.setString(3, page.getRegion());
            ps.setString(4, page.getFederalDistrict());
            ps.setString(5, page.getCity());
            ps.setString(6, page.getCountry());
            ps.setString(7, category_1);
            ps.setString(8, category_2);
            ps.setString(9, category_3);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException ex) {
            Logger.getLogger(PageDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //удаление
    public void deletePage(int id) {
        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM en WHERE id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getLastPage() {
        String result = null;
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM en WHERE `id`=(SELECT MAX(`id`) FROM en)");

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                result = rs.getString("link_ted");
            }
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    private String getCategory(String category) {

        String parentCat = "";
        String catName = "";
        
        insertCategory(parentCat, catName);

        return "";

    }

    private void insertCategory(String parentCat, String catName) {

    }

}


package projekakhir.model;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import projekakhir.modeldatabase.Model;

public class PenyebaranCovid extends Model{
    public PenyebaranCovid() {
        super();
    }

    public int getJumlahData(){
        try {
            int jmlData = 0;
            String query = "Select * from data_sampel";
            stmt = koneksi.createStatement();
            ResultSet resultSet = stmt.executeQuery(query);
            while(resultSet.next()){
                jmlData++;
            }
            return jmlData;
        } catch (SQLException e) {
            return 0;
        }
    }
    
    public String[][] getPenyebaranCovid(){
        try {
            int x = 0;
            String data[][] = new String[this.getJumlahData()][5];
            String query = "SELECT * FROM data_sampel";
            
            ResultSet resultSet = stmt.executeQuery(query);
            
            while (resultSet.next()){
                data[x][0] = resultSet.getString("nama_daerah");
                data[x][1] = resultSet.getString("confirmed");
                data[x][2] = resultSet.getString("active");
                data[x][3] = resultSet.getString("deaths");
                data[x][4] = resultSet.getString("recovered");
                x++;
            }
            return data;
        }catch (Exception e) {
            return null;
        }
    }

    public double[][] getPenyebaranCovidWP(){
        try {
            int x = 0;
            double data[][] = new double[this.getJumlahData()][4];
            String query = "SELECT * FROM data_sampel";
            
            ResultSet resultSet = stmt.executeQuery(query);
            
            while (resultSet.next()){
                data[x][0] = resultSet.getDouble("confirmed");
                data[x][1] = resultSet.getDouble("active");
                data[x][2] = resultSet.getDouble("deaths");
                data[x][3] = resultSet.getDouble("recovered");
                x++;
            }
            return data;
        }catch (Exception e) {
            return null;
        }
    }

    public String[] getPenyebaranCovidByNamaDaerah(String nama_daerah){
        String data[] = new String[5];
        try{
            String query = "SELECT * FROM data_sampel WHERE nama_daerah ='"+nama_daerah+"'";
            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.next();
            data[0] = resultSet.getString("nama_daerah");
            data[1] = resultSet.getString("confirmed");
            data[2] = resultSet.getString("active");
            data[3] = resultSet.getString("deaths");
            data[4] = resultSet.getString("recovered");
            return data;
        }catch(SQLException e) {
            return null;
        }
    }
    
    public void updatePenyebaranCovid(String nama_daerah, double confirmed, double active, double deaths, double recovered){
        try{
            String query = "UPDATE data_sampel SET nama_daerah = '"+nama_daerah+"'"+", confirmed ="+confirmed+", active = "+active+", deaths = "+deaths+", recovered = "+recovered+" WHERE nama_daerah = "+ "'"+nama_daerah+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Updated");
        }catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

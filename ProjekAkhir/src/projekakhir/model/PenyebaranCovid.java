
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
            String query = "Select * from movie";
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
    
    public String[][] getMovie(){
        try {
            int x = 0;
            String data[][] = new String[this.getJumlahData()][5];
            String query = "SELECT * FROM movie";
            
            ResultSet resultSet = stmt.executeQuery(query);
            
            while (resultSet.next()){
                data[x][0] = resultSet.getString("judul");
                data[x][1] = resultSet.getString("alur");
                data[x][2] = resultSet.getString("penokohan");
                data[x][3] = resultSet.getString("akting");
                data[x][4] = resultSet.getString("nilai");
                x++;
            }
            return data;
        }catch (Exception e) {
            return null;
        }
    }

    public String[] getMovieByJudul(String judul){
        String data[] = new String[5];
        try{
            String query = "SELECT * FROM movie WHERE judul ='"+judul+"'";
            ResultSet resultSet = stmt.executeQuery(query);
            resultSet.next();
            data[0] = resultSet.getString("judul");
            data[1] = resultSet.getString("alur");
            data[2] = resultSet.getString("penokohan");
            data[3] = resultSet.getString("akting");
            data[4] = resultSet.getString("nilai");
            return data;
        }catch(SQLException e) {
            return null;
        }
    }

    public void createMovie(String judul, double alur, double penokohan, double akting, double nilai){
        try{
            String query = "INSERT INTO movie VALUES ('"+judul+"','"+alur+"','"+penokohan+"','"+akting+"','"+nilai+"')";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dimasukkan");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void updateMovie(String judul, double alur, double penokohan, double akting, double nilai){
        try{
            String query = "UPDATE movie SET judul = '"+judul+"'"+", alur ="+alur+", penokohan = "+penokohan+", akting = "+akting+", nilai = "+nilai+" WHERE judul = "+ "'"+judul+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
        }catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public void deleteMovie(String judul){
        try{
            String query = "DELETE FROM movie WHERE judul = '"+judul+"'";
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}

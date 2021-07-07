package projekakhir.controller;

public interface ListenerCovid {
    boolean verifyInputData(String nama_daerah,Double confirmed, Double active, Double deaths, Double recovered);
    boolean verifyInputWeight(Double a,Double b,Double c, Double d);
}
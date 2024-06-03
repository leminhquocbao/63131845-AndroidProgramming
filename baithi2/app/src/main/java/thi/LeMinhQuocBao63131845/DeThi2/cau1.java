package thi.LeMinhQuocBao63131845.DeThi2;

public class cau1 {
    String name;
    String date;
    String landImageFileName;

    public cau1(String name, String date, String message, String landImageFileName) {
        this.name = name;
        this.date = date;
        this.landImageFileName = landImageFileName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }
}


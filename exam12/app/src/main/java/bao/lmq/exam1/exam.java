package bao.lmq.exam1;

public class exam {
    String name;
    String date;
    String message;
    String landImageFileName;

    public exam(String name, String date, String message, String landImageFileName) {
        this.name = name;
        this.date = date;
        this.message = message;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLandImageFileName() {
        return landImageFileName;
    }

    public void setLandImageFileName(String landImageFileName) {
        this.landImageFileName = landImageFileName;
    }
}

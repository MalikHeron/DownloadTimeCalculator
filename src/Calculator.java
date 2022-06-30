public class Calculator {

    private float speed;
    private float size;
    private float speedUnit;
    private float sizeUnit;

    public static void main(String[] args) {
        Calculator time = new Calculator();
        System.out.println(time.getTime(2, 2, 10, 20));
    }

    public String getTime(int speedOpt, int sizeOpt, int speed, int size) {
        setSize(size);
        setSpeed(speed);
        setSpeedUnit(speedOpt);
        setSizeUnit(sizeOpt);
        return calculateTime();
    }

    private void setSpeed(float speed) {
        this.speed = speed;
    }

    private void setSize(float size) {
        this.size = size;
    }

    private void setSpeedUnit(int opt) {
        switch (opt) {
            case 1:
                speedUnit = speed / 8; //megabits per second
                break;
            case 2:
                speedUnit = speed; //megabytes per second
                break;
            case 3:
                speedUnit = speed * 125; //gigabits per second
                break;
            case 4:
                speedUnit = speed * 1000; //gigabytes per second
                break;
            default:
                break;
        }
    }

    private void setSizeUnit(int opt) {
        switch (opt) {
            case 1:
                sizeUnit = size; //megabyte
                break;
            case 2:
                sizeUnit = size * 1000; //gigabyte
                break;
            case 3:
                sizeUnit = size * 1000000; //terabyte
                break;
            default:
                break;
        }
    }

    public String calculateTime() {
        float seconds = (sizeUnit / speedUnit);
        return toTime((int) seconds);
    }

    public String toTime(int seconds) {
        int days = seconds / 86400;
        int hrs = seconds / 3600;
        int minutes = seconds / 60;
        String out = "";

        // Get remaining hours
        while (hrs >= 24) {
            hrs -= 24;
        }

        // Get remaining minutes
        while (minutes >= 60) {
            minutes -= 60;
        }

        // Get remaining seconds
        while (seconds >= 60) {
            seconds -= 60;
        }

        if (days > 1) {
            out += "" + days + " days " + hrs + " hours " + minutes + " minutes " + seconds + " seconds";
        } else if (days == 1) {
            out += "" + days + " day " + hrs + " hours " + minutes + " minutes " + seconds + " seconds";
        } else {
            if (hrs > 1) {
                out += "" + hrs + " hours " + minutes + " minutes " + seconds + " seconds";
            } else if (hrs == 1) {
                out += "" + hrs + " hour " + minutes + " minutes " + seconds + " seconds";
            } else {
                if (minutes > 1) {
                    out += "" + minutes + " minutes " + seconds + " seconds";
                } else if (minutes == 1) {
                    out += "" + minutes + " minute " + seconds + " seconds";
                } else {
                    out += "" + seconds + " seconds";
                }
            }
        }

        return out;
    }
}

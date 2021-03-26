package leetcode.string;

class ValidateIPAddress {
    public String validIPAddress(String IP) {
        String ipv4[] = IP.split("\\.", -1);
        String ipv6[] = IP.split("\\:", -1);

        if (IP.chars().filter(c -> c == '.').count() == 3 && validateIPv4(ipv4)) {
            return "IPv4";

        } else if (IP.chars().filter(c -> c == ':').count() == 7 && validateIPv6(ipv6)) {
            return "IPv6";
        }
        return "Neither";
    }

    private boolean validateIPv4(String ip[]) {
        try {
            for (String s : ip) {
                int i = Integer.parseInt(s);
                if (!s.equals(String.valueOf(i)) || !(i >= 0 && i <= 255)) {
                    return false;
                }
            }
        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean validateIPv6(String ip[]) {
        try {
            for (String s : ip) {
                if (s.length() > 4 || Integer.parseInt(s, 16) < 0 || s.charAt(0) == '-') {
                    return false;
                }
            }

        } catch(NumberFormatException e) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new ValidateIPAddress().validIPAddress("1.0.1.");
    }
}
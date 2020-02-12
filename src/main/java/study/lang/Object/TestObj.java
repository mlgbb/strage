package study.lang.Object;


public class TestObj {
    private String name;
    private String address;

    public TestObj(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public TestObj() {
    }

    public String getAddress() {
        return address;
    }


    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int result = 1;
        if (name != null) result += name.hashCode();
        if (address != null) result += address.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "名字是:'" + name + '\'' +
                ", 家住: '" + address + '\'';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        TestObj obj1 = (TestObj) obj;
        if (name.equals(obj1.getName()) && address.equals(obj1.getAddress())) {
            return true;
        } else {
            return false;
        }

    }
}

package testing;

public class KeyBean {
    private int kid;
    private String name;

    public KeyBean(int kid, String name) {
        this.kid = kid;
        this.name = name;
    }

    public int getKid() {
        return kid;
    }

    public void setKid(int kid) {
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return "KeyBean{" +
                "kid=" + kid +
                ", name='" + name + '\'' +
                '}';
    }
}

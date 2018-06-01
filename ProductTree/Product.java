import JSON.JSONObject;

abstract class Product {
    // Variable
    protected String name;
    protected Long price;
    protected String manufacturer;
    protected Long quantity;

    // Setter & Getter
    public abstract String getProductType();
    public abstract void setAttribute(String attributes);
    public abstract String getAttribute(String keys);
    public abstract JSONObject toJSONObject();
}
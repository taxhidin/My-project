package eu.senla.game;

class ExampleItem {
    private String Image_Url;
    private String value_of_name;
    private int value_count_player;

    public ExampleItem(String image_Url, String value_of_name, int value_count_player) {
        Image_Url = image_Url;
        this.value_of_name = value_of_name;
        this.value_count_player = value_count_player;
    }

    public ExampleItem(String value_of_name, int value_count_player) {
        this.value_of_name = value_of_name;
        this.value_count_player = value_count_player;
    }

    public String getImage_Url() {
        return Image_Url;
    }

    public void setImage_Url(String image_Url) {
        Image_Url = image_Url;
    }

    public String getValue_of_name() {
        return value_of_name;
    }

    public void setValue_of_name(String value_of_name) {
        this.value_of_name = value_of_name;
    }

    public int getValue_count_player() {
        return value_count_player;
    }

    public void setValue_count_player(int value_count_player) {
        this.value_count_player = value_count_player;
    }
}

package pageUIs.admin;

public class AdminCustomerPUI {
    public static final String ADD_NEW_BUTTON = "//a[contains(string(), 'Add new')]";
    public static final String SELECT_CUSTOMER_ROLES_DROPDOWN_INPUT = "//ul[@id='SelectedCustomerRoleIds_taglist']/following-sibling::input";
    public static final String SELECT_CUSTOMER_ROLES_PARENT_DROPDOWN = "//ul[@id='SelectedCustomerRoleIds_taglist']/parent::div";
    public static final String SELECT_CUSTOMER_ROLES_ALL_CHILDREN_OPTION = "//ul[@id='SelectedCustomerRoleIds_listbox']/li";
    public static final String SELECT_CUSTOMER_ROLES_FIRST_CHILD_DELETE_ICON = "//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[@title='delete']";
    public static final String ACTIVE_CHECKBOX = "//input[@id='Active']";
    public static final String ADMIN_COMMENT_TEXT_AREA = "//textarea[@id='AdminComment']";
    public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "//button[@name='save-continue']";
    public static final String ALERT_ELEMENT = "//div[contains(@class, 'alert')]";
    public static final String BACK_TO_CUSTOMER_LIST_LINK = "//a[text()='back to customer list']";
    public static final String SEARCH_BUTTON = "//button[@id='search-customers']";

    public static final String DYNAMIC_GENDER_CHECKBOX_BY_GENDER = "//input[@id='Gender_%s']";
    public static final String DYNAMIC_SELECTING_CUSTOMER_ROLE = "//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[text()='%s']";
    public static final String DYNAMIC_CUSTOMER_DETAIL_IN_LIST = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[@nop-value='%s']";
    public static final String DYNAMIC_EDIT_ICON_BY_CUSTOMER_DETAIL = "//td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td/i[@nop-value='%s']/parent::td/following-sibling::td/a";

}

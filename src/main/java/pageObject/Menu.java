package pageObject;
public class Menu {
    public enum TopMenuEnum {
        PREMIUM("דמי ביטוח"),
        CONTACT("יצירת קשר"),
        BENEFITS("קצבאות והטבות"),
        RIGHTS("מיצוי זכויות");

        private final String displayValue;

        TopMenuEnum(String displayValue) {
            this.displayValue = displayValue;
        }

        public String getDisplayValue() {
            return displayValue;
        }
    }
}

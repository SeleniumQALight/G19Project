package pages.elements;

public class Messages {
    public static String genErrorMess() {
        return "Can not work with ";
    }

    public static String genCantFindMess() {
        return "Can not find ";
    }

    public static String genInputMess() {
        return " was entered";
    }

    public static String genButtonMess() {
        return " was clicked";
    }

    public static String genDisplayedMess(boolean state) {
        if (state) {
            return " is displayed";
        } else {
            return " is not displayed";
        }
    }

    public static String genExpectedDisplayedMess(boolean state) {
        if (state) {
            return ", but expected to be displayed";
        } else {
            return ", but expected not to be displayed";
        }
    }

    public static String genCloseMess() {
        return " were closed";
    }

    public static String genConditionMess(boolean state) {
        if (state) {
            return " are equals";
        } else {
            return " are not equals";
        }
    }

    public static String genMenuItem(String menuItem) {
        return menuItem + " menus' item";
    }

    public static String genSelectMess(boolean state) {
        if (state) {
            return " was selected";
        } else {
            return " was selected";
        }
    }

}


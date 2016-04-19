package mysite.main;

import mysite.web.action.Action;
import mysite.web.action.ActionFactory;

public class MainActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        return new IndexAction();
    }
}

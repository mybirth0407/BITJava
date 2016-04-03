package mysite.main;


import web.action.Action;
import web.action.ActionFactory;

public class MainActionFactory extends ActionFactory {
    @Override
    public Action getAction(String actionName) {
        return new IndexAction();
    }
}

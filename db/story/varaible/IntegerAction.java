package com.sapfil.ironsoul.db.story.varaible;

public class IntegerAction extends Action<IntegerVariable>{

    private int value;
    private ActionType actionType;


    @Override
    IntegerVariable apply(IntegerVariable variable) {
        switch (actionType){
            case CHANGE: {variable.value += value; break;}
            case SET: {variable.value = value; break;}
            default: // do nothing
        }
        return variable;
    }

    public static IntegerAction increase(int increaseValue){
        IntegerAction integerAction = new IntegerAction();
        integerAction.actionType = ActionType.CHANGE;
        integerAction.value = increaseValue;
        return integerAction;
    }

    public static IntegerAction decrease(int decreaseValue){
        IntegerAction integerAction = new IntegerAction();
        integerAction.actionType = ActionType.CHANGE;
        integerAction.value = -decreaseValue;
        return integerAction;
    }

    public static IntegerAction set(int setValue){
        IntegerAction integerAction = new IntegerAction();
        integerAction.actionType = ActionType.SET;
        integerAction.value = setValue;
        return integerAction;
    }

    private enum ActionType{
        CHANGE,
        SET
    }
}

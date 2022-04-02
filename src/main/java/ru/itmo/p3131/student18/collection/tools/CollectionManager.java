package ru.itmo.p3131.student18.collection.tools;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import ru.itmo.p3131.student18.collection.CustomStack;
import ru.itmo.p3131.student18.objectclasses.HumanBeing;

import java.io.File;
import java.time.format.DateTimeFormatter;
import java.util.EmptyStackException;

public class CollectionManager {
    private File inputFile;
    private CustomStack<HumanBeing> stack;

    public CollectionManager() {
        this.stack = new CustomStack<>();
        try {
            CollectionLoader loader = new CollectionLoader(new Gson());
            init(loader.execute());
            inputFile = loader.getFile();
        } catch (JsonSyntaxException e) {
            System.out.println("Not enable to parse json from this file.");
        }
    }

    //Managing and init methods:
    public void init(CustomStack<HumanBeing> tmpStack) {
        stack.addAll(tmpStack);
        System.out.println("Collection was successfully initialized.");
        //Collections.sort(stack);          //Collection might be sorted right after initialization
        updateBiggestId();
    }

    public String getType() {
        String[] tokens = stack.getClass().getName().split("\\.");
        return tokens[tokens.length - 1];
    }

    public String getInitTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return stack.getInitTime().format(formatter);
    }

    public int getSize() {
        return stack.size();
    }

    public CustomStack<HumanBeing> getStack() {
        return stack;
    }

    public File getInputFile() {
        return inputFile;
    }
    //Updating methods:

    /**
     * Method is used only in init() method to set the biggest id value to static int IdCounter.
     */
    public void updateBiggestId() {
        int maxId = HumanBeing.staticId();
        for (HumanBeing human : stack) {
            maxId = Math.max(human.getId(), maxId);
        }
        HumanBeing.idCounterSetter(maxId);
    }

    public int getPositionById(int id) {
        int position = 0;
        for (HumanBeing human : stack) {
            if (id == human.getId()) {
                return position;
            }
            ++position;
        }
        return position;
    }

    public boolean isIdValid(int id) {
        for (HumanBeing human : stack) {
            if (id == human.getId()) {
                return true;
            }
        }
        return false;
    }

    //Methods for Command.execute():
    public void info() {
        System.out.printf("\nCollection information:" +
                        "\n\tType: " + "%s" +
                        "\n\tInitialization time: %s" +
                        "\n\tSize: %d\n\n",
                getType(), getInitTime(), getSize());
    }

    /**
     * A method to print each java.ru.itmo.p3131.student18.collection element, starting from the heap(if it's stack), to standard output.
     */
    public void show() {
        System.out.println("\nCollection elements:");
        System.out.println(stack + "\n");
    }

    public void add(HumanBeing humanBeing) {
        stack.add(humanBeing);
    }

    public void update(HumanBeing updatedHumanBeing) {
        int position = getPositionById(updatedHumanBeing.getId());
        stack.removeElementAt(position);
        stack.add(position, updatedHumanBeing);
    }

    public void remove_by_id(int id) {
        stack.removeElementAt(getPositionById(id));
        System.out.println("Element was deleted.");
    }

    public void remove_first() {
        try {
            stack.pop();
            System.out.println("First element of java.ru.itmo.p3131.student18.collection has been removed.");
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty.");
        }
    }

    /**
     * Removes the last element of java.ru.itmo.p3131.student18.collection. This could be performed with "foreach",
     * but it performed the way it meant to be done(by making another stack and dragging
     * elements on it, deleting the last element in real stack and dragging other elements back).
     */
    public void remove_last() {
        CustomStack<HumanBeing> tmpStack = new CustomStack<>();
        try {
            while (stack.size() > 1) {
                tmpStack.push(stack.pop());
            }
            stack.pop();
            System.out.println("Last element of java.ru.itmo.p3131.student18.collection has been removed.");
            while (tmpStack.size() > 0) {
                stack.push(tmpStack.pop());
            }
        } catch (EmptyStackException e) {
            System.out.println("Stack is empty.");
        }
    }

    public void remove_greater(int id) {
        if (stack.size() > 0) {
            CustomStack<HumanBeing> tmpStack = new CustomStack<>();
            while (stack.size() > 0) {
                if (stack.peek().getId() > id) {
                    stack.pop();
                } else {
                    tmpStack.push(stack.pop());
                }
            }
            System.out.println("All elements greater than " + id + " are deleted.");
            while (tmpStack.size() > 0) {
                stack.push(tmpStack.pop());
            }
        } else {
            System.out.println("Stack is empty.");
        }
    }

    public void count_by_impact_speed(float impactSpeed) {
        int count = 0;
        for (HumanBeing human : stack) {
            if (human.getImpactSpeed() == impactSpeed) {
                ++count;
            }
        }
        System.out.println("Amount of elements with impact speed " + impactSpeed + ": " + count);
    }

    public void filter_starts_with_name(String subName) {
        int count = 0;
        for (HumanBeing human : stack) {
            if (human.getName().startsWith(subName)) {
                System.out.println(human);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no elements starting with substring " + subName + ".");
        }
    }

    public void filter_less_than_impact_speed(float impactSpeed) {
        int count = 0;
        for (HumanBeing human : stack) {
            if (human.getImpactSpeed() < impactSpeed) {
                System.out.println(human);
                count++;
            }
        }
        if (count == 0) {
            System.out.println("There are no elements with field impact speed less than " + impactSpeed);
        }
    }

    public void clear() {
        stack.clear();
        System.out.println("Collection is cleared.");
    }


}

package br.inatel.marcelovca90;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Runner
{
    public static void selectActivities(List<Activity> activities)
    {
        // 1) Sort the activities according to their finishing time.
        Collections.sort(activities, Comparator.comparing(Activity::getEnd));

        // 2) Select the first activity from the sorted array and print it.
        System.out.print(activities.get(0) + " (0)");

        // 3) For each remaining activity in the sorted array ...
        for (int i = 1, lastSelectedIndex = 0; i < activities.size(); i++)
        {
            // If the start time of this activity is greater than or equal to the finish
            // time of previously selected activity then select this activity and print it.
            if (activities.get(i).getStart() >= activities.get(lastSelectedIndex).getEnd())
            {
                System.out.print(", " + activities.get(i) + " (" + i + ")");
                lastSelectedIndex = i;
            }
        }

        // Line break
        System.out.println();
    }

    public static void main(String[] args)
    {
        List<Activity> listOfThree = Arrays.asList(
            new Activity(10, 20),
            new Activity(12, 25),
            new Activity(20, 30));

        selectActivities(listOfThree);

        List<Activity> listOfSix = Arrays.asList(
            new Activity(1, 2),
            new Activity(3, 4),
            new Activity(0, 6),
            new Activity(5, 7),
            new Activity(8, 9),
            new Activity(5, 9));

        selectActivities(listOfSix);
    }
}

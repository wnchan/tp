package seedu.address.storage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.group.Group;
import seedu.address.model.group.tasks.TaskList;
import seedu.address.model.person.Person;

/**
 * Jackson-friendly version of {@link Group}.
 */
public class JsonAdaptedGroup {

    public static final String INVALID_NUMBER_MESSAGE = "Group number is invalid!";

    private final int number;
    private final List<JsonAdaptedPerson> members = new ArrayList<>();
    private final List<JsonAdaptedTask> tasks = new ArrayList<>();  // add a list of JsonAdaptedTask

    /**
     * Constructs a {@code JsonAdaptedGroup} with the given group details.
     */
    @JsonCreator
    public JsonAdaptedGroup(@JsonProperty("number") int number,
                            @JsonProperty("members") List<JsonAdaptedPerson> members,
                            @JsonProperty("tasks") List<JsonAdaptedTask> tasks) {  // add tasks parameter
        this.number = number;
        if (members != null) {
            this.members.addAll(members);
        }
        if (tasks != null) {
            this.tasks.addAll(tasks);
        }
    }

    /**
     * Converts a given {@code Group} into this class for Jackson use.
     */
    public JsonAdaptedGroup(Group source) {
        number = source.getNumber();
        members.addAll(source.getMembers().stream()
            .map(JsonAdaptedPerson::new)
            .collect(Collectors.toList()));
        tasks.addAll(source.getTasks().getTaskList().stream()  // add tasks to constructor
            .map(JsonAdaptedTask::new)
            .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted social media object into the model's {@code Group} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted group.
     */
    public Group toModelType() throws IllegalValueException {
        final List<Person> groupMembers = new ArrayList<>();
        final TaskList groupTasks = new TaskList();

        for (JsonAdaptedPerson member : members) {
            groupMembers.add(member.toModelType());
        }
        for (JsonAdaptedTask task : tasks) {
            groupTasks.addTask(task.toModelType());
        }

        if (number < 1) {
            throw new IllegalValueException(INVALID_NUMBER_MESSAGE);
        }

        final Set<Person> members = new HashSet<>(groupMembers);

        return new Group(number, members, groupTasks);  // add tasks to constructor
    }
}

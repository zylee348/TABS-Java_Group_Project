package seedu.address.ui;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.assignment.Assignment;
import seedu.address.model.group.Group;
import seedu.address.model.person.Person;

import java.util.logging.Logger;

public class AssignmentListPanel {
    private static final String FXML = "AssignmentListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @javafx.fxml.FXML
    private ListView<Person> assignmentListView;

    public AssignmentListPanel(ObservableList<Person> personList) {
        super(FXML);
        assignmentListView.setItems(personList);
        assignmentListView.setCellFactory(listView -> new PersonListPanel.PersonListViewCell());

    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class AssignmentListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new AssignmentCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}

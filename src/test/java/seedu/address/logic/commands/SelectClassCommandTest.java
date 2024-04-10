package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;
import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;

import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.ReadOnlyClassBook;
import seedu.address.model.ReadOnlyUserPrefs;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Classes;
import seedu.address.model.person.Person;
import seedu.address.testutil.ClassBuilder;

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Predicate;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalClassBook;

public class SelectClassCommandTest {
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), getTypicalClassBook());

    public SelectClassCommandTest() throws DataLoadingException, IOException {
    }

    @Test
    public void constructor_nullIndex_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new SelectClassCommand(null));
    }
//    @Test
//    public void execute_negativeIndex_throwsCommandException() throws DataLoadingException, IOException {
//        Classes validClass = new ClassBuilder().build();
//        CreateClassCommand createClassCommand = new CreateClassCommand(validClass);
//        SelectClassCommandTest.ModelStub modelStub = new CreateClassCommandTest.ModelStubWithClass(validClass);
//        assertThrows(CommandException.class, () -> new SelectClassCommand(-1));
//    }
    @Test
    public void execute_invalidIndex_throwsCommandException() {
        int outOfBoundIndex = model.getFilteredClassList().size() + 1;
        SelectClassCommand selectClassCommand = new SelectClassCommand(outOfBoundIndex);

        assertCommandFailure(selectClassCommand, model, Messages.MESSAGE_INVALID_CLASS_DISPLAYED_INDEX);
    }

    /**
     * A default model stub that have all of the methods failing.
     */
    private class ModelStub implements Model {
        @Override
        public void setUserPrefs(ReadOnlyUserPrefs userPrefs) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyUserPrefs getUserPrefs() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public GuiSettings getGuiSettings() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setGuiSettings(GuiSettings guiSettings) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getAddressBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public Path getClassBookFilePath() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBookFilePath(Path addressBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClassBookFilePath(Path classBookFilePath) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void addPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setAddressBook(ReadOnlyAddressBook newData) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyAddressBook getAddressBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setClassBook(ReadOnlyClassBook classBook) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ReadOnlyClassBook getClassBook() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasPerson(Person person) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void deletePerson(Person target) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void clear() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void setPerson(Person target, Person editedPerson) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Person> getFilteredPersonList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public ObservableList<Classes> getFilteredClassList() {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void updateFilteredPersonList(Predicate<Person> predicate) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public String getFormattedClassList() {
            return null;
        }

        @Override
        public void createClass(Classes classes) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public void removeClass(Classes classes) {
            throw new AssertionError("This method should not be called.");
        }

        @Override
        public boolean hasClass(Classes classes) {
            return false;
        }

        @Override
        public void selectClass(Classes classes) {

        }

        @Override
        public String getSelectedClassName() {
            return null;
        }

        @Override
        public void viewClasses() {
        }

        @Override
        public void hideStudentsUi() {
        }
    }
}

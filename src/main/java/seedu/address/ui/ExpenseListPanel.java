package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import javafx.scene.text.TextAlignment;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.account.entry.Expense;

public class ExpenseListPanel extends UiPart<Region> {
    private static final String FXML = "ExpenseListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(ExpenseListPanel.class);

    @FXML
    private Label expenseLabel;

    @FXML
    private ListView<Expense> expenseListView;

    /**
     * Creates a {@code ExpenseListPanel} with the given {@code ObservableList}.
     */
    public ExpenseListPanel(ObservableList<Expense> expenses) {
        super(FXML);
        expenseLabel.setText("Expenses");
        expenseLabel.setTextAlignment(TextAlignment.CENTER);
        expenseListView.setItems(expenses);
        expenseListView.setCellFactory(listView -> new ExpenseListViewCell());
    }

    class ExpenseListViewCell extends ListCell<Expense> {
        @Override
        protected void updateItem(Expense expense, boolean isEmpty) {
            super.updateItem(expense, isEmpty);

            if (isEmpty || expense == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new EntryCard(expense, getIndex() + 1).getRoot());
            }
        }
    }

}

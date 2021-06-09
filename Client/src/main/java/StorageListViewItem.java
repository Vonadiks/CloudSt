import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class StorageListViewItem extends ListCell<StorageItem> {

    FXMLLoader localStorageItemLoader;
    public CheckBox isLocalItemChecked;
    public Label localItemName;
    public Label localItemSize;
    public Label localItemModified;
    public VBox localStorageItemCell;



    @Override
    public void updateSelected(boolean selected) {
        super.updateSelected(selected);
        if (selected){
            isLocalItemChecked.setSelected(true);
        }else{
            isLocalItemChecked.setSelected(false);
        }
    }

    @Override
    protected void updateItem(StorageItem item, boolean empty) {
        super.updateItem(item, empty);
        try {
            if (empty || item == null) {
                setText(null);
                setGraphic(null);
            } else {
                if (localStorageItemLoader == null) {
                    localStorageItemLoader = new FXMLLoader(getClass().getResource("/ItemCellView.fxml"));
                    localStorageItemLoader.setController(this);
                    try {
                        localStorageItemLoader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                localItemName.setText(item.getName());
                Tooltip name = new Tooltip(item.getName());
                localItemName.setTooltip(name);

                Tooltip size = new Tooltip();
                if (item.getSize() / 1073741824 > 0) {
                    localItemSize.setText(item.getSize() / 1073741824 + " GB");
                    size.setText(localItemSize.getText());
                    localItemSize.setTooltip(size);
                } else if (item.getSize() / 1048576 > 0) {
                    localItemSize.setText((item.getSize() / 1048576) + " MB");
                    size.setText(localItemSize.getText());
                    localItemSize.setTooltip(size);
                } else if (item.getSize() / 1024 > 0) {
                    localItemSize.setText(item.getSize() / 1024 + " KB");
                    size.setText(localItemSize.getText());
                    localItemSize.setTooltip(size);
                } else if (item.getSize() / 1024 <= 0) {
                    localItemSize.setText(item.getSize() + " bytes");
                    size.setText(localItemSize.getText());
                    localItemSize.setTooltip(size);
                }
                isLocalItemChecked.setSelected(item.isChosen());
                localItemModified.setText("" + item.getLastModificationDate());
                Tooltip timeOfLastModification = new Tooltip(localItemModified.getText());
                localItemModified.setTooltip(timeOfLastModification);
            }
            setText(null);
            setGraphic(localStorageItemCell);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }
}


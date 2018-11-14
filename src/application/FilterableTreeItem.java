package application;

import java.lang.reflect.Field;
import java.util.function.Predicate;

import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TreeItem;

public class FilterableTreeItem extends  TreeItem<String> {
	
	final private ObservableList<TreeItem<String>> sourceList;
    private FilteredList<TreeItem<String>> filteredList;
    
     ObjectProperty<TreeItemPredicate<String>> predicate = new SimpleObjectProperty<TreeItemPredicate<String>>();

 
    public FilterableTreeItem(String value) {
		super(value);
		this.sourceList = FXCollections.observableArrayList();
		this.filteredList = new FilteredList<>(this.sourceList);
		this.filteredList.predicateProperty().bind(Bindings.createObjectBinding(() -> {
			Predicate<TreeItem<String>> p =  child -> {
				// Set the predicate of child items to force filtering
				if (child instanceof FilterableTreeItem) {
					FilterableTreeItem filterableChild = (FilterableTreeItem) child;
					filterableChild.setPredicate(this.predicate.get());
				}
				// If there is no predicate, keep this tree item
				if (this.predicate.get() == null)
					return true;
				// If there are children, keep this tree item
				if (child.getChildren().size() > 0)
					return true;
				// Otherwise ask the TreeItemPredicate
				return this.predicate.get().test(this, child.getValue());
			};
			return p;
		}, this.predicate));

		setHiddenFieldChildren(this.filteredList);
	}
 
    @SuppressWarnings("unchecked")
	protected <T> void setHiddenFieldChildren(ObservableList<TreeItem<T>> list) {
        try {
            Field childrenField = TreeItem.class.getDeclaredField("children"); //$NON-NLS-1$
            childrenField.setAccessible(true);
            childrenField.set(this, list);
 
            Field declaredField = TreeItem.class.getDeclaredField("childrenListener"); //$NON-NLS-1$
            declaredField.setAccessible(true);
            list.addListener((ListChangeListener<? super TreeItem<T>>) declaredField.get(this));
        } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
            throw new RuntimeException("Could not set TreeItem.children", e); //$NON-NLS-1$
        }
    }
 
    public <T> ObservableList<TreeItem<String>> getInternalChildren() {
        return this.sourceList;
    }
    
    public final ObjectProperty<TreeItemPredicate<String>> predicateProperty() {
        return this.predicate;
    }
    
    public final TreeItemPredicate<String> getPredicate() {
        return this.predicate.get();
    }
    
    public final void setPredicate(TreeItemPredicate<String> predicate) {
    	this.predicate.set(predicate);
    }
    
    @FunctionalInterface
    public interface TreeItemPredicate<T> {
     
        boolean test(TreeItem<T> parent, T value);
     
        static <T> TreeItemPredicate<T> create(Predicate<T> predicate) {
            return (parent, value) -> predicate.test(value);
        }
     
    }

}



/**
 * 
 */
package java.Schneider.Definitions;

import java.util.Date;

/**
 * @author Julian
 *
 */

public abstract class ToDoItem {

	public static final String typeWork = "WORK";
	public static final String typePersonal = "PERSONAL";
	private Long itemKey;
	private String itemName;
	private String itemDescription;
	private int itemPriority;
	private Date itemDeadline;
	private boolean itemComplete;
	private String itemType;
	private String lastUpdatedBy;
	private Date lastUpdatedTstmp;
	

	public Long getItemKey() {
		return itemKey;
	}

	public void setItemKey(Long itemKey) {
		this.itemKey = itemKey;
	}
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemPriority() {
		return itemPriority;
	}

	public void setItemPriority(int itemPriority) {
		this.itemPriority = itemPriority;
	}

	public Date getItemDeadline() {
		return itemDeadline;
	}

	public void setItemDeadline(Date itemDeadline) {
		this.itemDeadline = itemDeadline;
	}

	public boolean isItemComplete() {
		return itemComplete;
	}

	public void setItemComplete(boolean itemComplete) {
		this.itemComplete = itemComplete;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	public void setLastUpdatedBy(String lastUpdatedBy) {
		this.lastUpdatedBy = lastUpdatedBy;
	}

	public Date getLastUpdatedTstmp() {
		return lastUpdatedTstmp;
	}

	public void setLastUpdatedTstmp(Date lastUpdatedTstmp) {
		this.lastUpdatedTstmp = lastUpdatedTstmp;
	}
	

	/**
	 * 
	 */
	public ToDoItem() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import generated.ActT;
import generated.ActivityT;
import generated.DistributionFieldT;
import generated.Group;
import generated.OptionT;
import generated.PointT;
import generated.RefT;
import generated.SoundT;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.xml.bind.JAXBException;
import view.AITGView;
import view.CGFIView;
import view.FileChooser;
import view.MainView;
import view.OptionView;
import view.PointView;
import view.RefView;

/**
 *
 * @author s124392
 */
public class MainViewController extends Controller {
    //<editor-fold defaultstate="collapsed" desc="Instance Variables">
    /**
     * The main view.
     */
    private MainView mainView;
    
    /**
     * The current image directory.
     */
    private String imageDir;
    
    /**
     * The current group data file.
     */
    private String groupFile;
    
    /**
     * The current field data file.
     */
    private String fieldFile;
    
    /**
     * The current activity data file.
     */
    private String activityFile;
    
    /**
     * Indicates whether or not an activity is currently selected.
     */
    private boolean activitySelected;
    
    /**
     * Indicates whether or not a proceed option is currently selected.
     */
    private boolean optionSelected;
    
    /**
     * Indicates whether or not a field is currently selected.
     */
    private boolean fieldSelected;
    
    /**
     * Indicates whether or not a group is currently selected.
     */
    private boolean groupSelected;
    
    /**
     * Indicates whether or not an image is currently selected.
     */
    private boolean imageSelected;
    
    /**
     * Indicates whether or not an activity point is currently selected.
     */
    private boolean pointSelected;
    
    /**
     * Indicates whether or not an activities data file has been loaded.
     */
    private boolean activitiesLoaded;
    
    /**
     * Indicates whether or not a fields data file has been loaded.
     */
    private boolean fieldsLoaded;
    
    /**
     * Indicates whether or not a group data file has been loaded.
     */
    private boolean groupsLoaded;
    
    /**
     * Indicates whether or not an images directory has been loaded.
     */
    private boolean imagesLoaded;
    
    /**
     * Instance of AddImageToGroupView.
     */
    private AITGView addImageToGroupView;
    
    /**
     * Instance of CreateGroupFromImages.
     */
    private CGFIView createGroupFromImagesView;
    
    /**
     * Instance of OptionView.
     */
    private OptionView optionView;
    
    /**
     * Instance of RefView.
     */
    private RefView refView;
    
    /**
     * Instance of PointView.
     */
    private PointView pointView;
    
    /**
     * Indicates whether or not validation has been completed.
     */
    private boolean validated;
    
    /**
     * Path to file where Activity data will be exported.
     */
    private String activityExportLocation;
    
    /**
     * Path to file where Field data will be exported.
     */
    private String fieldExportLocation;
    
    /**
     * Path to file where Group data will be exported.
     */
    private String groupExportLocation;
    //</editor-fold>
    
    public MainViewController() {
        super();
    }
    
    public void initialise() {
        if (mainView == null) {
            mainView = new MainView(this);
        }
        activityExportLocation = "";
        fieldExportLocation = "";
        groupExportLocation = "";
        setActivitiesLoaded(false);
        setFieldsLoaded(false);
        setGroupsLoaded(false);
        setImagesLoaded(false);
        setActivitySelected(false);
        setFieldSelected(false);
        setGroupSelected(false);
        setImageSelected(false);
        setValidated(false);
        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.setResizable(false);
        mainView.centerize();
        toggleInnerComponents(mainView.getImageEditPanel(), isImagesLoaded());
        toggleInnerComponents(mainView.getGroupEditPanel(), isGroupsLoaded());
        toggleInnerComponents(mainView.getFieldEditPanel(), isFieldsLoaded());
        toggleInnerComponents(mainView.getActivityEditPanel(), isActivitiesLoaded());
        mainView.toggleExportButton(false);
        mainView.setVisible(true);
    }
    
    
    public void loadImageDir() {
        String title = "Select Image Directory";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            imageDir = fc.getSelectedFile().toString();
            mainView.setImageDir(imageDir);
            setImagesLoaded(true);
        }
        populateImageList("");
        toggleInnerComponents(mainView.getImageEditPanel(), isImagesLoaded());
        mainView.toggleAddButton(isImageSelected());
        mainView.toggleCreateButton(isImageSelected());
        mainView.toggleSelectButton(isImageSelected());
    }
    
    
    public void loadGroupFile() {
        String title = "Select Group Data File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            groupFile = fc.getSelectedFile().toString();
            mainView.setGroupFile(groupFile);
            setGroupsLoaded(true);
        }
        populateGroupList("");
        toggleInnerComponents(mainView.getGroupEditPanel(), isGroupsLoaded());
        toggleInnerComponents(mainView.getGroupPanel(), isGroupSelected());
        mainView.toggleGroupDeleteButton(isGroupSelected());
        mainView.toggleGroupSaveButton(isGroupSelected());
        mainView.toggleGroupSelectButton(isGroupSelected());
    }
    
    
    public void loadFieldFile() {
        String title = "Select Field Data File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            fieldFile = fc.getSelectedFile().toString();
            mainView.setFieldFile(fieldFile);
            setFieldsLoaded(true);
        }
        populateFieldList("");
        toggleInnerComponents(mainView.getFieldEditPanel(), isFieldsLoaded());
        toggleInnerComponents(mainView.getFieldPanel(), isFieldSelected());
        mainView.toggleFieldDeleteButton(isFieldSelected());
        mainView.toggleFieldSaveButton(isFieldSelected());
        mainView.toggleFieldSelectButton(isGroupSelected());
    }
    
    
    public void loadActivityFile() {
        String title = "Select Activity Data File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            activityFile = fc.getSelectedFile().toString();
            mainView.setActivityFile(activityFile);
            setActivitiesLoaded(true);
        }
        populateActivityList("");
        toggleInnerComponents(mainView.getActivityEditPanel(),
                isActivitiesLoaded());
        toggleInnerComponents(mainView.getActivityPanel(),
                isActivitySelected());
        mainView.toggleActivityDeleteButton(isActivitySelected());
        mainView.toggleActivityDuplicateButton(isActivitySelected());
        mainView.toggleActivitySaveButton(isActivitySelected());
        mainView.toggleActivitySelectButton(isActivitySelected());
    }
    
    public void loadActivityExport() {
        String title = "Select Activity Data Export File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            setActivityExportLocation(fc.getSelectedFile().toString());
            mainView.setActivityExport(activityExportLocation);
        }
    }
    
    public void loadFieldExport() {
        String title = "Select Field Data Export File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            setFieldExportLocation(fc.getSelectedFile().toString());
            mainView.setFieldExport(fieldExportLocation);
        }
    }
    
    public void loadGroupExport() {
        String title = "Select Group Data Export File";
        FileChooser fc = new FileChooser(title);
        int option = fc.showDialog(mainView, title);
        if (option == JFileChooser.APPROVE_OPTION) {
            setGroupExportLocation(fc.getSelectedFile().toString());
            mainView.setGroupExport(groupExportLocation);
        }
    }
    
    
    public void previewImage(List<Object> images) {
        if (!(images.isEmpty())) {
            String image = (String) images.get(0);
            image = imageDir + "\\" + image;
            ImageIcon icon = new ImageIcon(image);
            icon = scaleImage(icon);
            mainView.setPreviewImage(icon);
            setImageSelected(true);
        } else {
            setImageSelected(false);
        }
        mainView.toggleSelectButton(isImageSelected() && isImagesLoaded());
        mainView.toggleCreateButton(isImageSelected() && isImagesLoaded()
            && isGroupsLoaded());
        mainView.toggleAddButton(isImageSelected() && isImagesLoaded() &&
            isGroupsLoaded());
    }
    
    
    public void viewGroup(String value, int n) {
        boolean empty = value.equals("");
        if (!empty) {
            Group group = getGroupByName(value);
            setGroupSelected(true);
            if (group != null) {
                mainView.setGroupName(group.getName());
                String values = "";
                for (String v : group.getValues()) {
                    values = values + v + "\n";
                }
                mainView.setGroupValues(values);
            }
        } else {
            setGroupSelected(false);
        }
        toggleInnerComponents(mainView.getGroupPanel(), isGroupSelected()
                && isGroupsLoaded()  && n == 1);
        mainView.toggleGroupSaveButton(isGroupSelected() && isGroupsLoaded()
                && n == 1);
        mainView.toggleGroupDeleteButton(isGroupSelected() && isGroupsLoaded()
                && n == 1);
        mainView.toggleGroupSelectButton(isGroupSelected() && isGroupsLoaded());
    }
    
    
    public void viewField(String value, int n) {
        boolean empty = value.equals("");
        if (!empty) {
            DistributionFieldT field = getFieldByName(value);
            setFieldSelected(true);
            setPointSelected(false);
            if (field != null) {
                mainView.setFieldName(field.getName());
                mainView.setFieldValues(pointsToModel(field.getPoint()));
                mainView.setPivotX(field.getPivotStart().getX());
                mainView.setPivotY(field.getPivotStart().getY());
            }
        } else {
            setFieldSelected(false);
        }
        toggleInnerComponents(mainView.getFieldPanel(), isFieldSelected()
                && isFieldsLoaded()  && n == 1);
        mainView.toggleFieldSaveButton(isFieldSelected() && isFieldsLoaded()
                && n == 1);
        mainView.toggleFieldDeleteButton(isFieldSelected() && isFieldsLoaded()
                && n == 1);
        mainView.toggleFieldSelectButton(isFieldSelected() && isFieldsLoaded());
        mainView.togglePointEditButton(isPointSelected() && n == 1);
        mainView.togglePointDeleteButton(isPointSelected() && n == 1);
    }
    
    
    public void viewActivity(String value, int n) {
        boolean empty = value.equals("");
        toggleInnerComponents(mainView.getActivityEditPanel(),
                isActivitiesLoaded());
        toggleInnerComponents(mainView.getActivityPanel(), isActivitySelected()
                && isActivitiesLoaded() && n == 1);
        mainView.toggleActivityDeleteButton(isActivitySelected() &&
                isActivitiesLoaded() && n == 1);
        mainView.toggleActivityDuplicateButton(isActivitySelected() &&
                isActivitiesLoaded() && n == 1);
        mainView.toggleActivityNewButton(isActivitiesLoaded());
        mainView.toggleActivitySaveButton(isActivitySelected() &&
                isActivitiesLoaded() && n == 1);
        mainView.toggleActivitySelectButton(isActivitySelected() &&
                isActivitiesLoaded());
        mainView.toggleSelectionToActivityTextButton(selection != null);
        mainView.toggleSelectionToImagePathButton(selection != null);
        if (!empty) {
            ActivityT activity = getActivityByName(value);
            setActivitySelected(true);
            setOptionSelected(false);
            if (activity != null) {
                int k = activity.getOption().size();
                mainView.setActivityName(activity.getName());
                mainView.setActivityImagePath(activity.getImagePath());
                mainView.setActivityText(activity.getText());
                mainView.setActivitySoundValue(activity.getSound().getValue());
                mainView.setActivitySoundPeriod(String.valueOf(
                        activity.getSound().getPeriod()));
                mainView.setActivitySoundRepeats(
                        activity.getSound().getRepeats());
                mainView.setOptionList(optionsToModel(
                        activity.getOption()));
                mainView.toggleOptionAddButton(isActivitySelected() && n == 1
                        && k < 8);
                mainView.toggleOptionEditButton(isOptionSelected() && n == 1);
                mainView.toggleOptionDeleteButton(isOptionSelected() && n == 1
                        && k > 1);
            }
        } else {
            setActivitySelected(false);
        }
    }
    
    public void viewOption() {
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        if (optionView == null) {
            optionView = new OptionView(this);
        }
        optionView.clear();
        optionView.setButtonName(option.getButtonName());
        optionView.setDelay(option.getDelay());
        optionView.setHideDelay(option.isHideDelay());
        optionView.setShowValue(option.isShowValue());
        optionView.setIsField(option.isIsField());
        optionView.setSetField(option.getSetField());
        optionView.setPivotX(option.getPivotX());
        optionView.setPivotY(option.getPivotY());
        DefaultListModel lm = new DefaultListModel();
        for (RefT ref : option.getReference()) {
            String element = ref.getName() + " "
                    + String.valueOf(ref.getProbability());
            lm.addElement(element);
        }
        optionView.setReferenceListModel(lm);
        optionView.toggleAddButton(true);
        optionView.setVisible(true);
        mainView.setEnabled(false);
    }
    
    public void viewRef() {
        if (refView == null) {
            refView = new RefView(this);
        }
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        int[] indices = optionView.getRefIndices();
        int index = indices[0];
        RefT ref = option.getReference().get(index);
        refView.setActivityModel(getActivityListModel(""));
        refView.setActName(ref.getName());
        refView.setProbability(ref.getProbability());
        refView.setVisible(true);
        optionView.setEnabled(false);
    }
    
    
    public void updateImageList(String text) {
        populateImageList(text);
    }
    
    
    public void updateGroupList(String text) {
        populateGroupList(text);
    }
    
    
    public void updateFieldList(String text) {
        populateFieldList(text);
        mainView.togglePointDeleteButton(false);
        mainView.togglePointEditButton(false);
    }
    
    
    public void updateActivityList(String text) {
        populateActivityList(text);
    }
    
    public void updateRefActivityList() {
        String searchText = refView.getSearchText();
        refView.setActivityModel(getActivityListModel(searchText));
        viewRef();
    }
    
    
    public void setImageSelection(List selection) {
        this.selection = selectionToStringList(selection, false);
        mainView.toggleSelectionToActivityTextButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.toggleSelectionToImagePathButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.setSelection(selectionToStringList(selection, false));
    }
    
    
    public void setGroupSelection(List selection) {
        this.selection = selectionToStringList(selection, true);
        mainView.toggleSelectionToActivityTextButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.toggleSelectionToImagePathButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.setSelection(selectionToStringList(selection, true));
    }
    
    
    public void setFieldSelection(List selection) {
        this.selection = selectionToStringList(selection, false);
        mainView.toggleSelectionToActivityTextButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.toggleSelectionToImagePathButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.setSelection(selectionToStringList(selection, false));
    }
    
    
    public void setActivitySelection(List selection) {
        this.selection = selectionToStringList(selection, false);
        mainView.toggleSelectionToActivityTextButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.toggleSelectionToImagePathButton(isActivitiesLoaded()
                && isActivitySelected() && selection != null);
        mainView.setSelection(selectionToStringList(selection, false));
    }
    
    
    public void saveActivity(String value) {
        ActivityT activity = getActivityByName(value);
        activity.setName(mainView.getActivityName());
        activity.setImagePath(mainView.getActivityImagePath());
        activity.setText(mainView.getActivityText());
        activity.getSound().setValue(mainView.getActivitySoundValue());
        activity.getSound().setPeriod(mainView.getActivitySoundPeriod());
        activity.getSound().setRepeats(mainView.getActivitySoundRepeats());
        populateActivityList(mainView.getActivitySearchText());
    }
    
    
    public void saveField(String value) {
        DistributionFieldT field = getFieldByName(value);
        field.setName(mainView.getFieldName());
        field.getPivotStart().setX(mainView.getFieldPivotX());
        field.getPivotStart().setY(mainView.getFieldPivotY());
        populateFieldList(mainView.getFieldSearchText());
    }
    
    
    public void saveGroup(String value) {
        Group group = getGroupByName(value);
        group.setName(mainView.getGroupName());
        String values = mainView.getGroupValues();
        String[] lines = values.split("\\n");
        List<String> valueList = group.getValues();
        valueList.clear();
        for (String line : lines) {
            valueList.add(line);
        }
        populateGroupList(mainView.getGroupSearchText());
    }
    
    public void saveOption() {
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        option.setButtonName(optionView.getButtonName());
        option.setDelay(optionView.getDelay());
        option.setHideDelay(optionView.hideTimer());
        option.setShowValue(optionView.showValue());
        option.setIsField(optionView.isField());
        option.setPivotX(optionView.getPivotX());
        option.setPivotY(optionView.getPivotY());
        option.setSetField(optionView.getSetField());
        ListModel lm = optionView.getReferenceListModel();
        option.getReference().clear();
        for (int i = 0; i < lm.getSize(); i++) {
            Object o = lm.getElementAt(i);
            String aux = String.valueOf(o);
            String[] words = aux.split(" ");
            String act = "";
            for (int j = 0; j < words.length - 1; j++) {
                act = act + " " + words[j];
            }
            act = act.trim();
            String prob = words[words.length - 1];
            double probability = Double.parseDouble(prob);
            RefT ref = new RefT();
            ref.setName(act);
            ref.setProbability(probability);
            option.getReference().add(ref);
        }
        mainView.setEnabled(true);
        viewActivity(activity.getName(), 1);
        optionView.clear();
        optionView.setVisible(false);
    }
    
    public void cancelOption() {
        mainView.setEnabled(true);
        optionView.clear();
        optionView.setVisible(false);
    }
    
    public void saveRef() {
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        int[] indices = optionView.getRefIndices();
        int index = indices[0];
        RefT ref = option.getReference().get(index);
        ref.setName(refView.getActName());
        ref.setProbability(refView.getProbability());
        optionView.setEnabled(true);
        viewOption();
        refView.setVisible(false);
    }
    
    public void cancelRef() {
        optionView.setEnabled(true);
        refView.setVisible(false);
    }
    
    public void newActivity() {
        int index = getDuplicateActivityIndex("New Activity");
        ActivityT activity = new ActivityT();
        activity.setName("New Activity " + String.valueOf(index));
        activity.setImagePath("");
        SoundT sound = new SoundT();
        sound.setValue("NONE");
        sound.setPeriod(1000);
        sound.setRepeats("0");
        activity.setSound(sound);
        activities.add(activity);
        populateActivityList(mainView.getActivitySearchText());
    }    
    
    public void newField() {
        int index = getDuplicateFieldIndex("New Field");
        DistributionFieldT field = new DistributionFieldT();
        field.setName("New Field " + String.valueOf(index));
        PointT pivotStart = new PointT();
        pivotStart.setX(0.0);
        pivotStart.setY(0.0);
        field.setPivotStart(pivotStart);
        fields.add(field);
        populateFieldList(mainView.getFieldSearchText());
    }
    
    public void newPoint() {
        PointT point = new PointT();
        point.setX(0.0);
        point.setY(0.0);
        DistributionFieldT field = getFieldByName(mainView.getFieldSelection());
        field.getPoint().add(point);
        viewField(field.getName(), 1);
    }
    
    public void newGroup() {
        int index = getDuplicateGroupIndex("New Group");
        Group group = new Group();
        group.setName("New Group " + String.valueOf(index));
        groups.add(group);
        populateGroupList(mainView.getGroupSearchText());
    }
    
    public void newReference() {
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        RefT ref = new RefT();
        ref.setName(activities.get(0).getName());
        ref.setProbability(0.0);
        option.getReference().add(ref);
        viewOption();
    }
    
    public void deleteReference() {
        ActivityT activity = getActivityByName(mainView.getActivitySelection());
        OptionT option = activity.getOption().get(mainView.getOptionIndex());
        LinkedList<RefT> references = new LinkedList<RefT>();
        String selection = "";
        int[] indices = optionView.getRefIndices();
        for (int index : indices) {
            RefT ref = option.getReference().get(index);
            references.add(ref);
            selection = ref.getName() + " ";
        }
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete the following reference(s) from the proceed option:\n"
                + selection + "\nDo you wish to prceed?");
        if (response == 0) {
            for (RefT ref : references) {
                option.getReference().remove(ref);
            }
            viewOption();
        }
    }
    
    public void deleteActivity(String value) {
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete the following activity:\n" + value + "\n"
            + "Do you wish to proceed?");
        if (response == 0) {
            ActivityT activity = getActivityByName(value);
            activities.remove(activity);
            populateActivityList(mainView.getActivitySearchText());
        }
    }
    
    public void deleteField(String value) {
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete the following distribution field:\n" + value + "\n"
            + "Do you wish to prceed?");
        if (response == 0) {
            DistributionFieldT field = getFieldByName(value);
            fields.remove(field);
            populateFieldList(mainView.getFieldSearchText());
        }
    }
    
    public void deletePoint(String fieldName, int index) {
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete the following point from the distribution field:\nPoint #"
                + index + "\nDo you wish to prceed?");
        if (response == 0) {
            DistributionFieldT field = getFieldByName(fieldName);
            field.getPoint().remove(index);
            viewField(fieldName, 0);
        }
    }
    
    public void deleteGroup(String value) {
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete the following group:\n" + value + "\n"
            + "Do you wish to prceed?");
        if (response == 0) {
            Group group = getGroupByName(value);
            groups.remove(group);
            populateGroupList(mainView.getGroupSearchText());
        }
    }
    
    public void duplicateActivity(String value) {
        int index = getDuplicateActivityIndex(value);
        ActivityT original = getActivityByName(value);
        ActivityT duplicate = new ActivityT();
        duplicate.setName(value + " (" + String.valueOf(index) + ")");
        duplicate.setImagePath(original.getImagePath());
        duplicate.setText(original.getText());
        duplicate.setSound(original.getSound());
        for (OptionT option : original.getOption()) {
            duplicate.getOption().add(option);
        }
        activities.add(duplicate);
        populateActivityList(mainView.getActivitySearchText());
    }
    
    public void appendSelectionToImagePath() {
        String text = mainView.getActivityImagePath();
        for (String value : selection) {
            text = text + value;
        }
        mainView.setActivityImagePath(text);
    }
    
    
    public void appendSelectionToActivityText() {
        String text = mainView.getActivityText();
        for (String value : selection) {
            text = text + value;
        }
        mainView.setActivityText(text);
    }
    
    
    public void appendSelectionToGroupValues() {
        String text = mainView.getGroupValues();
        for (String value : selection) {
            text = text + value + "\n";
        }
        mainView.setGroupValues(text);
    }
    
    public void showAITGView() {
        if (addImageToGroupView == null) {
            addImageToGroupView = new AITGView(this, groups);
        }
        addImageToGroupView.setVisible(true);
        mainView.setEnabled(false);
    }
    
    public void addImageSelectionToGroup(String groupName) {
        Group group = getGroupByName(groupName);
        List<String> values = selectionToStringList(
                mainView.getImageSelection(), false);
        for (String value : values) {
            group.getValues().add(value);
        }
        mainView.setEnabled(true);
        addImageToGroupView.setVisible(false);
    }
    
    public void showCGFIView() {
        if (createGroupFromImagesView == null) {
            createGroupFromImagesView = new CGFIView(this, groups);
        }
        createGroupFromImagesView.setVisible(true);
        mainView.setEnabled(false);
    }
    
    public void cancelCGFI() {
        mainView.setEnabled(true);
        createGroupFromImagesView.setVisible(false);
    }
    
    public void cancelAITG() {
        mainView.setEnabled(true);
        addImageToGroupView.setVisible(false);
    }
    
    public void createGroupFromImageSelection(String groupName) {
        Group group = new Group();
        group.setName(groupName);
        List<String> values = selectionToStringList(
                mainView.getImageSelection(), false);
        for (String value : values) {
            group.getValues().add(value);
        }
        groups.add(group);
        populateGroupList(mainView.getGroupSearchText());
        mainView.setEnabled(true);
        createGroupFromImagesView.setVisible(false);
    }
    
    public void addOption(String activityName) {
        ActivityT activity = getActivityByName(activityName);
        OptionT option = new OptionT();
        option.setButtonName("Default");
        option.setDelay("0");
        option.setHideDelay(false);
        option.setIsField(false);
        option.setPivotX(0.0);
        option.setPivotY(0.0);
        option.setSetField("0");
        option.setShowValue(true);
        activity.getOption().add(option);
        viewActivity(activityName, 1);
    }
    
    public void deleteOption(String activityName, int optionIndex) {
        int response = JOptionPane.showConfirmDialog(null, "You are about to "
            + "delete option #\n" + String.valueOf(optionIndex) + "\n" 
            + "From activity: " + activityName + "\nDo you wish to prceed?");
        if (response == 0) {
            ActivityT activity = getActivityByName(activityName);
            activity.getOption().remove(optionIndex);
            viewActivity(activityName, 1);
        }
    }
    
//    public void showPointView(int index) {
//        DistributionFieldT field = getFieldByName(mainView.getFieldSelection());
//        PointT point = field.getPoint().get(index);
//        if (pointView == null) {
//            pointView = new PointView(this);
//        }
//        DefaultListModel lm = new DefaultListModel();
//        for (ActT act : point.getAct()) {
//            lm.addElement(act.getName());
//        }
//        pointView.setVisible(true);
//        pointView.populateActivityList(activities, "");
//        pointView.setReferenceList(lm);
//        mainView.setEnabled(false);
//    }
//    
//    public void savePoint(PointT point) {
//        
//    }
    
    public void export() {
        try {
            marshallActivities(activityExportLocation);
            marshallFields(fieldExportLocation);
            marshallGroups(groupExportLocation);
        } catch (JAXBException ex) {
            Logger.getLogger(MainViewController.class.getName()).log(
                    Level.SEVERE, null, ex);
        }
    }
    
    private List<String> selectionToStringList(List selection, boolean groups) {
        LinkedList<String> result = new LinkedList<String>();
        for (Object o : selection) {
            String s = String.valueOf(o);
            if (groups) {
                s = "{" + s + "}";
            }
            result.add(s);
        }
        return result;
    }
    
    /**
     * Returns a scaled instance of {@code image} with respect to {@code view}
     * 's {@code imagePanel}.
     * @param image the image to scale.
     * @return 
     */
    private ImageIcon scaleImage(ImageIcon image) {
        Dimension size = mainView.getImageLabel().getSize();
        int labelWidth = (int) size.getWidth();
        int labelHeight = (int) size.getHeight();
        int imageWidth = image.getIconWidth();
        int imageHeight = image.getIconHeight();
        BufferedImage bufferedImage = toBufferedImage(image);
        double imageRatio = (((double) imageWidth) / ((double) imageHeight));
        int newImageWidth = (int) (imageRatio * labelHeight);
        Image scaledInstance = bufferedImage.getScaledInstance(newImageWidth,
                labelHeight, Image.SCALE_SMOOTH);
        return new ImageIcon(scaledInstance);
    }
    
    private BufferedImage toBufferedImage(ImageIcon icon) {
        BufferedImage bi = new BufferedImage(
        icon.getIconWidth(),
        icon.getIconHeight(),
        BufferedImage.TYPE_INT_RGB);
        Graphics g = bi.createGraphics();
        // paint the Icon to the BufferedImage.
        icon.paintIcon(null, g, 0,0);
        g.dispose();
        return bi;
    }
    
    private void populateImageList(String text) {
        File dir = new File(imageDir);
        DefaultListModel lm = new DefaultListModel();
        recursiveImageSearch(text, dir, lm);
        mainView.setImageList(lm);
    }
    
    private void recursiveImageSearch(String text, File dir,
            DefaultListModel lm) {
        for (File file : dir.listFiles()) {
            String name = file.getName();
            String ext = name.substring(name.length() - 4, name.length());
            String path = file.getPath();
            if (file.isDirectory()) {
                recursiveImageSearch(text, file, lm);
            }
            if (path.contains(text)) {
                path = path.replace(imageDir, "");
                if (allowedExtension(ext)) {
                    lm.addElement(path);
                }
            }
        }
    }
    
    private void populateGroupList(String text) {
        DefaultListModel lm = new DefaultListModel();
        if (groups == null) {
            unmarshallGroups(groupFile);
        }
        for (Group group : groups) {
            String name = group.getName();
            if (name.contains(text) || name.contains("New Group")) {
                lm.addElement(name);
            }
        }
        mainView.setGroupList(lm);
    }
    
    private void populateFieldList(String text) {
        DefaultListModel lm = new DefaultListModel();
        if (fields == null) {
            unmarshallFields(fieldFile);
        }
        for (DistributionFieldT field : fields) {
            String name = field.getName();
            if (name.contains(text) || name.contains("New Field")) {
                lm.addElement(name);
            }
        }
        mainView.setFieldList(lm);
    }
    
    private void populateActivityList(String text) {  
        mainView.setActivityList(getActivityListModel(text));
    }
    
    private DefaultListModel getActivityListModel(String text) {
        DefaultListModel lm = new DefaultListModel();
        if (activities == null) {
            unmarshallActivities(activityFile);
        }
        for (ActivityT activity : activities) {
            String name = activity.getName();
            if (name.contains(text) || name.contains("New Activity")) {
                lm.addElement(name);
            }
        }
        return lm;
    }
    
    private boolean allowedExtension(String ext) {
        String[] allowedExtensions = {"jpg", "jpeg", "png", "gif", "JPG", "PNG", "GIF", "JPEG"};
        boolean allowed = false;
        for (String s : allowedExtensions) {
            if (ext.contains(s)) {
                allowed = true;
                break;
            }
        }
        return allowed;
    }
    
    private ListModel pointsToModel(List<PointT> points) {
        DefaultListModel lm = new DefaultListModel();
        for (PointT point : points) {
            String element = "(" + point.getX() + "," + point.getY() + ") {";
            for (int i = 0; i < point.getAct().size(); i++) {
                ActT act = point.getAct().get(i);
                element = element + act.getName();
                if (i < point.getAct().size() - 1) {
                    element = element + ", ";
                }
            }
            element = element + "}";
            lm.addElement(element);
        }
        return lm;
    }
    
    private ListModel optionsToModel(List<OptionT> options) {
        DefaultListModel lm = new DefaultListModel();
        for (OptionT option : options) {
            String name = "";
            if (option.getButtonName().equals("")) { // Delay
                name = "Delay(" + option.getDelay() + ")";
            } else {
                name = "Button(" + option.getButtonName() + ")";
            }
            lm.addElement(name);
        }
        return lm;
    }
    
    private void isExportable() {
        boolean actLocated = !(activityExportLocation.equals(""));
        boolean fieldLocated = !(fieldExportLocation.equals(""));
        boolean groupLocated = !(groupExportLocation.equals(""));
        mainView.toggleExportButton(isValidated() && actLocated && fieldLocated
                && groupLocated && isActivitiesLoaded() && isFieldsLoaded()
                && isGroupsLoaded());
    }
    
    //<editor-fold defaultstate="collapsed" desc="Accessor Methods">
    //<editor-fold defaultstate="collapsed" desc="Get Methods">
    /**
     * @return the activitySelected
     */
    public boolean isActivitySelected() {
        return activitySelected;
    }
    
    /**
     * @return the optionSelected
     */
    public boolean isOptionSelected() {
        return optionSelected;
    }

    /**
     * @return the fieldSelected
     */
    public boolean isFieldSelected() {
        return fieldSelected;
    }

    /**
     * @return the groupSelected
     */
    public boolean isGroupSelected() {
        return groupSelected;
    }

    /**
     * @return the imageSelected
     */
    public boolean isImageSelected() {
        return imageSelected;
    }
    
    /**
     * @return the pointSelected
     */
    public boolean isPointSelected() {
        return pointSelected;
    }

    /**
     * @return the activitiesLoaded
     */
    public boolean isActivitiesLoaded() {
        return activitiesLoaded;
    }

    /**
     * @return the fieldsLoaded
     */
    public boolean isFieldsLoaded() {
        return fieldsLoaded;
    }

    /**
     * @return the groupsLoaded
     */
    public boolean isGroupsLoaded() {
        return groupsLoaded;
    }

    /**
     * @return the imagesLoaded
     */
    public boolean isImagesLoaded() {
        return imagesLoaded;
    }
    
    /**
     * @return the validated
     */
    public boolean isValidated() {
        return validated;
    }

    /**
     * @return the activityExportLocation
     */
    public String getActivityExportLocation() {
        return activityExportLocation;
    }

    /**
     * @return the fieldExportLocation
     */
    public String getFieldExportLocation() {
        return fieldExportLocation;
    }

    /**
     * @return the groupExportLocation
     */
    public String getGroupExportLocation() {
        return groupExportLocation;
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Set Methods">
    /**
     * @param activitySelected the activitySelected to set
     */
    public void setActivitySelected(boolean activitySelected) {
        this.activitySelected = activitySelected;
    }
    
    /**
     * @param optionSelected the optionSelected to set
     */
    public void setOptionSelected(boolean optionSelected) {
        this.optionSelected = optionSelected;
    }

    /**
     * @param fieldSelected the fieldSelected to set
     */
    public void setFieldSelected(boolean fieldSelected) {
        this.fieldSelected = fieldSelected;
    }

    /**
     * @param groupSelected the groupSelected to set
     */
    public void setGroupSelected(boolean groupSelected) {
        this.groupSelected = groupSelected;
    }

    /**
     * @param imageSelected the imageSelected to set
     */
    public void setImageSelected(boolean imageSelected) {
        this.imageSelected = imageSelected;
    }
    
    /**
     * @param pointSelected the pointSelected to set
     */
    
    public void setPointSelected(boolean pointSelected) {
        this.pointSelected = pointSelected;
    }

    /**
     * @param activitiesLoaded the activitiesLoaded to set
     */
    public void setActivitiesLoaded(boolean activitiesLoaded) {
        this.activitiesLoaded = activitiesLoaded;
    }

    /**
     * @param fieldsLoaded the fieldsLoaded to set
     */
    public void setFieldsLoaded(boolean fieldsLoaded) {
        this.fieldsLoaded = fieldsLoaded;
    }

    /**
     * @param groupsLoaded the groupsLoaded to set
     */
    public void setGroupsLoaded(boolean groupsLoaded) {
        this.groupsLoaded = groupsLoaded;
    }

    /**
     * @param imagesLoaded the imagesLoaded to set
     */
    public void setImagesLoaded(boolean imagesLoaded) {
        this.imagesLoaded = imagesLoaded;
    }
    
        /**
     * @param validated the validated to set
     */
    public void setValidated(boolean validated) {
        this.validated = validated;
        isExportable();
    }

    /**
     * @param activityExportLocation the activityExportLocation to set
     */
    public void setActivityExportLocation(String activityExportLocation) {
        this.activityExportLocation = activityExportLocation;
        isExportable();
    }

    /**
     * @param fieldExportLocation the fieldExportLocation to set
     */
    public void setFieldExportLocation(String fieldExportLocation) {
        this.fieldExportLocation = fieldExportLocation;
        isExportable();
    }

    /**
     * @param groupExportLocation the groupExportLocation to set
     */
    public void setGroupExportLocation(String groupExportLocation) {
        this.groupExportLocation = groupExportLocation;
        isExportable();
    }
    //</editor-fold>
    //</editor-fold>
}

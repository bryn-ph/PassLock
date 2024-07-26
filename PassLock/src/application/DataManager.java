package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private static final String FILE_PATH = "entries.dat";

    public static void saveEntries(ObservableList<Entry> entries) throws IOException {
        List<Entry> serializableList = new ArrayList<>(entries);
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(serializableList);
        }
    }

    public static ObservableList<Entry> loadEntries() throws IOException, ClassNotFoundException {
        File file = new File(FILE_PATH);
        if (!file.exists()) {
            return FXCollections.observableArrayList();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            @SuppressWarnings("unchecked")
			List<Entry> entries = (List<Entry>) ois.readObject();
            return FXCollections.observableArrayList(entries);
        }
    }
}
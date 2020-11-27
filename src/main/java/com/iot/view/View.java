package com.iot.view;

import com.iot.controller.CredentialsController;
import com.iot.controller.GenreController;
import com.iot.controller.LabelController;
import com.iot.controller.PlaylistController;
import com.iot.controller.UserController;
import com.iot.model.entity.Credentials;
import com.iot.model.entity.Genre;
import com.iot.model.entity.Label;
import com.iot.model.entity.Playlist;
import com.iot.model.entity.User;
import com.iot.view.Menu;
import com.iot.view.Printable;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class View {
  private static final Scanner SCANNER = new Scanner(System.in);
  private final Map<String, Printable> menu = new LinkedHashMap<>();

  private final CredentialsController credentialsController = new CredentialsController();
  private final GenreController genreController = new GenreController();
  private final LabelController labelController = new LabelController();
  private final UserController userController = new UserController();
  private final PlaylistController playlistController = new PlaylistController();


  public View() {

    menu.put("11", this::getAllCredentials);
    menu.put("12", this::getCredentialById);
    menu.put("13", this::createCredentials);
    menu.put("14", this::updateCredentials);
    menu.put("15", this::deleteCredentials);

    menu.put("21", this::getAllGenres);
    menu.put("22", this::getGenreById);
    menu.put("23", this::createGenre);
    menu.put("24", this::updateGenre);
    menu.put("25", this::deleteGenre);

    menu.put("31", this::getAllLabels);
    menu.put("32", this::getLabelById);
    menu.put("33", this::createLabel);
    menu.put("34", this::updateLabel);
    menu.put("35", this::deleteLabel);

    menu.put("41", this::getAllUsers);
    menu.put("42", this::getUserById);
    menu.put("43", this::createUser);
    menu.put("44", this::updateUser);
    menu.put("45", this::deleteUser);

    menu.put("51", this::getAllPlaylists);
    menu.put("52", this::getPlaylistById);
    menu.put("53", this::createPlaylist);
    menu.put("54", this::updatePlaylist);
    menu.put("55", this::deletePlaylist);

  }


  public final void show() {
    String input;
    Menu showMenu = new Menu();
    showMenu.displayMenu();
    System.out.println("\n( ͡° ͜ʖ ͡°) Shoot your shot:\n");
    do {
      try {
        input = SCANNER.next();
        menu.get(input).print();
      } catch (Exception ignored) {
      }
    } while (SCANNER.hasNext());
  }


  //-------------------------------------------------------------------------
  //          CREDENTIALS
  //--------------------------------------------------------------------------


  private void getAllCredentials() throws SQLException {
    System.out.println("\nGETting credentials...");
    System.out.println(credentialsController.findAll() + "\n");
  }

  private void getCredentialById() throws SQLException {
    System.out.println("\nGETting credentials... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(credentialsController.findOne(id) + "\n");
  }

  private Credentials getCredentialsInputs() throws SQLException {
    System.out.println("\nEnter bcrypt password: ");
    String userName = SCANNER.next();
    System.out.println("Enter user name: ");
    String dcryptPassword = SCANNER.next();
    System.out.println("Enter user id: ");
    Integer userId = SCANNER.nextInt();
    User user = userController.findOne(userId);
    return new Credentials(userName, dcryptPassword, user);
  }

  private void createCredentials() throws SQLException {
    System.out.println("\nCREATing credentials...");
    Credentials credential = getCredentialsInputs();
    credentialsController.create(credential);
    System.out.println("Hurrey! Credentials successfully created!\n");
  }

  private void updateCredentials() throws SQLException {
    System.out.println("\nUPDATing credentials... Enter ID: ");
    Integer id = SCANNER.nextInt();
    Credentials credential = getCredentialsInputs();
    credential.setId(id);

    credentialsController.update(credential.getId(), credential);
    System.out.println("Updated credential with Id=" + id + "\n");
  }

  private void deleteCredentials() throws SQLException {
    System.out.println("\nDELETing credential... Enter ID: ");
    int id = SCANNER.nextInt();

    credentialsController.delete(id);
    System.out.println("Deleted credential with ID=" + id + "\n");
  }

  //--------------------------------------------------------------------
  //                        GENRE
  //-------------------------------------------------------------------

  private void getAllGenres() throws SQLException {
    System.out.println("\nGETting genres...");
    System.out.println(genreController.findAll() + "\n");
  }

  private void getGenreById() throws SQLException {
    System.out.println("\nGETting genres... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(genreController.findOne(id) + "\n");
  }

  private Genre getGenreInputs() throws SQLException {
    System.out.println("\nEnter name of genre: ");
    String name = SCANNER.next();
    return new Genre(name);
  }

  private void createGenre() throws SQLException {
    System.out.println("\nCREATing genre...");
    Genre genre = getGenreInputs();
    genreController.create(genre);
    System.out.println("Hurrey! Just created a genre\n");
  }

  private void updateGenre() throws SQLException {
    System.out.println("\nUPDATing genre... Enter ID: ");
    Integer id = SCANNER.nextInt();
    Genre genre = getGenreInputs();
    genre.setId(id);

    genreController.update(genre.getId(), genre);
    System.out.println("Updated genre with ID=" + id + " \n");
  }

  private void deleteGenre() throws SQLException {
    System.out.println("\nDELETing genre... Enter ID: ");
    int id = SCANNER.nextInt();

    genreController.delete(id);
    System.out.println("Just deleted genre with ID=" + id + " \n");
  }

  //----------------------------------------------------------------
  //                      LABEL
  // ----------------------------------------------------------------

  private void getAllLabels() throws SQLException {
    System.out.println("\nGETting label...");
    System.out.println(labelController.findAll() + "\n");
  }

  private void getLabelById() throws SQLException {
    System.out.println("\nGETting label... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(labelController.findOne(id) + "\n");
  }

  private Label getLabelInputs() {
    System.out.println("\nEnter name of label: ");
    String name = SCANNER.next();
    return new Label(name);
  }

  private void createLabel() throws SQLException {
    System.out.println("\nCREATing label..");
    Label label = getLabelInputs();
    labelController.create(label);
    System.out.println("Hurrey! Just created a label\n");
  }

  private void updateLabel() throws SQLException {
    System.out.println("\nUPDATing label... Enter ID: ");
    Integer id = SCANNER.nextInt();
    Label label = getLabelInputs();
    label.setId(id);

    labelController.update(label.getId(), label);
    System.out.println("Updated label with ID=" + id + "\n");
  }

  private void deleteLabel() throws SQLException {
    System.out.println("\nDELETing label... Enter ID: ");
    int id = SCANNER.nextInt();

    labelController.delete(id);
    System.out.println("Just deleted label with ID=" + id + "\n");
  }

  //-----------------------------------------------------------------
  //                                       USER
  //-----------------------------------------------------------------

  private void getAllUsers() throws SQLException {
    System.out.println("\nGETting user...");
    System.out.println(userController.findAll() + "\n");
  }

  private void getUserById() throws SQLException {
    System.out.println("\nGETting user... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(userController.findOne(id) + "\n");
  }

  private User getUserInputs() throws SQLException {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();
    System.out.println("\nEnter surname: ");
    String surName = SCANNER.next();
    System.out.println("\nEnter email: ");
    String email = SCANNER.next();
    return new User(name, surName, email);
  }

  private void createUser() throws SQLException {
    System.out.println("\n[USER / CREATE]");
    User user = getUserInputs();
    userController.create(user);
    System.out.println("Hurrey! Crated user\n");
  }

  private void updateUser() throws SQLException {
    System.out.println("\nUPDATing user... Enter ID: ");
    Integer id = SCANNER.nextInt();
    User user = getUserInputs();
    user.setId(id);

    userController.update(user.getId(), user);
    System.out.println("Just deleted user with ID=" + id + "\n");
  }

  private void deleteUser() throws SQLException {
    System.out.println("\nDELETing user... Enter ID: ");
    int id = SCANNER.nextInt();

    userController.delete(id);
    System.out.println("Just deleted user with ID=" + id + "\n");
  }

  //----------------------------------------------------------------
  //                            PLAYLIST
  //----------------------------------------------------------------

  private void getAllPlaylists() throws SQLException {
    System.out.println("\nGETting playlist...");
    System.out.println(playlistController.findAll() + "\n");
  }

  private void getPlaylistById() throws SQLException {
    System.out.println("\nGETting playlist... Enter ID: ");
    Integer id = SCANNER.nextInt();
    System.out.println(playlistController.findOne(id) + "\n");
  }

  private Playlist getPlaylistInputs() {
    System.out.println("\nEnter name: ");
    String name = SCANNER.next();
    System.out.println("\nEnter number of songs: ");
    Integer numberOfSongs = SCANNER.nextInt();
    System.out.println("\nEnter genre id: ");
    Integer genreId = SCANNER.nextInt();
    System.out.println("\nEnter label id: ");
    Integer labelId = SCANNER.nextInt();
    System.out.println("\nEnter user id: ");
    Integer userId = SCANNER.nextInt();
    return new Playlist(name, numberOfSongs, genreId, labelId, userId);
  }

  private void createPlaylist() throws SQLException {
    System.out.println("\nCREATing playlist...");
    Playlist playlist = getPlaylistInputs();
    playlistController.create(playlist);
    System.out.println("Hurrey! Created a playlist\n");
  }

  private void updatePlaylist() throws SQLException {
    System.out.println("\nUPDATing playlist... Enter ID: ");
    Integer id = SCANNER.nextInt();
    Playlist playlist = getPlaylistInputs();
    playlist.setId(id);

    playlistController.update(playlist.getId(), playlist);
    System.out.println("Updated playlist with ID=" + id + " \n");
  }

  private void deletePlaylist() throws SQLException {
    System.out.println("\nDELETing playlist... Enter ID: ");
    int id = SCANNER.nextInt();

    playlistController.delete(id);
    System.out.println("Deleted playlist with ID=" + id + " \n");
  }

}

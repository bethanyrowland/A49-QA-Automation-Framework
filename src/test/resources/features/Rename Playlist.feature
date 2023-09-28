Feature: Rename Playlist feature

  Scenario: Rename Playlist Success
    Given I am logged in
    When I double click on playlist
    And I type new playlist name
    Then playlist is renamed successfully

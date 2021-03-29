package de.onlinehome.mann.martin.botm;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.blogspot.debukkitsblog.net.Datapackage;

public class BreathOfTheMinecraft {
	
	static JFrame frame;
	JPanel panel;
	
	JMenuBar menuBar;
	JMenu menuTabs;
	JMenu menuGithub;
	
	JMenu menuSocialMedia;
	
	JMenuItem creditsButton;
	JMenuItem screenshotsButton;
	JMenuItem newsButton;
	JMenuItem discordButton;
	JMenuItem youtubeButton;
	
	JMenuItem codeButton;
	JMenuItem downloadsButton;
	JMenuItem forumButton;
	JMenuItem wikiButton;
	
	JLabel botmIcon;
	JLabel credits;
	JLabel screenshots;
	JLabel news;
	JLabel discord;
	JLabel discordLink;
	JLabel youtube;
	JLabel youtubeLink;
	
	String version = "v1.1.1";
	static int versionId = 5;
	
	public static void main(String[] args) {
		new BreathOfTheMinecraft();
	}
	
	public BreathOfTheMinecraft() {
		ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("textures/BotMIcon.png"));
		
		frame = new JFrame("Breath of the Minecraft");
		panel = new JPanel();
		
		menuBar = new JMenuBar();
		menuTabs = new JMenu("Tabs");
		menuGithub = new JMenu("GitHub");

		menuSocialMedia = new JMenu("Social Media");
		
		creditsButton = new JMenuItem("Credits");
		screenshotsButton = new JMenuItem("Screenshots");
		newsButton = new JMenuItem("News");
		discordButton = new JMenuItem("Discord");
		youtubeButton = new JMenuItem("YouTube");
		
		codeButton = new JMenuItem("Code");
		downloadsButton = new JMenuItem("Downloads");
		forumButton = new JMenuItem("Forum");
		wikiButton = new JMenuItem("Wiki");
		
		creditsButton.addActionListener(new ButtonClickListener());
		screenshotsButton.addActionListener(new ButtonClickListener());
		newsButton.addActionListener(new ButtonClickListener());
		discordButton.addActionListener(new ButtonClickListener());
		youtubeButton.addActionListener(new ButtonClickListener());
		codeButton.addActionListener(new ButtonClickListener());
		downloadsButton.addActionListener(new ButtonClickListener());
		forumButton.addActionListener(new ButtonClickListener());
		wikiButton.addActionListener(new ButtonClickListener());
		
		botmIcon = new JLabel(icon);
		credits = new JLabel("<html><body>Die Breath of the Minecraft-App wurde von Nitram21 programmiert.<br>Version: " + version + "</body></html>");
		screenshots = new JLabel();
		news = new JLabel();
		discord = new JLabel("<html><body>Du willst immer auf dem laufenden bleiben? Dann tritt doch unserem Discord-Server bei,<br>indem du</body></html>");
		discordLink = new JLabel("hier klickst!");
		youtube = new JLabel("<html><body>Du willst immer auf dem laufenden bleiben? Dann schau doch bei unserem YouTube-Kanal vorbei,<br>indem du </body></html>");
		youtubeLink = new JLabel("hier klickst!");
		
		credits.setForeground(Color.WHITE);
		screenshots.setForeground(Color.WHITE);
		news.setForeground(Color.WHITE);
		discord.setForeground(Color.WHITE);
		discordLink.setForeground(Color.BLUE);
		youtube.setForeground(Color.WHITE);
		youtubeLink.setForeground(Color.BLUE);

		menuTabs.add(creditsButton);
		menuTabs.add(screenshotsButton);
		menuTabs.add(newsButton);
		menuTabs.addSeparator();
		menuTabs.add(menuSocialMedia);
		menuSocialMedia.add(discordButton);
		menuSocialMedia.add(youtubeButton);
		menuGithub.add(codeButton);
		menuGithub.add(downloadsButton);
		menuGithub.add(forumButton);
		menuGithub.add(wikiButton);
		
		menuBar.add(menuTabs);
		menuBar.add(menuGithub);
		
		frame.add(botmIcon);
		frame.add(credits);
		frame.add(screenshots);
		frame.add(news);
		frame.add(discord);
		frame.add(discordLink);
		frame.add(youtube);
		frame.add(youtubeLink);
		frame.add(panel);

		frame.setBounds(10, 10, 1200, 650);
		
		botmIcon.setBounds(10, 10, 64, 64);
		credits.setBounds(70, 10, 600, 80);
		screenshots.setBounds(frame.getWidth() / 2 - 684 / 2, frame.getHeight() / 2 - 354 / 2, 684, 354);
		news.setBounds(70, 10, 600, 100);
		discord.setBounds(70, 10, 600, 80);
		discordLink.setBounds(126, 43, 100, 30);
		youtube.setBounds(70, 10, 600, 80);
		youtubeLink.setBounds(126, 43, 100, 30);
		
		frame.setIconImage(icon.getImage());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setJMenuBar(menuBar);
		
		panel.setOpaque(true);
		panel.setBackground(Color.DARK_GRAY);
		
		botmIcon.setVisible(true);
		credits.setVisible(true);
		screenshots.setVisible(false);
		news.setVisible(false);
		discord.setVisible(false);
		discordLink.setVisible(false);
		youtube.setVisible(false);
		youtubeLink.setVisible(false);
		menuBar.setVisible(true);
		menuTabs.setVisible(true);
		
		frame.setVisible(true);
		
		getVersion();
		
		MouseListener ml = new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(e.getSource() == discordLink) {
					try {
						Desktop.getDesktop().browse(new URI("https://discord.gg/cJebY37vty"));
					} catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
				} else if(e.getSource() == youtubeLink) {
					try {
						Desktop.getDesktop().browse(new URI("https://www.youtube.com/channel/UC4PG2TobTvmsOVTWFClnmWA"));
					} catch (IOException | URISyntaxException ex) {
						ex.printStackTrace();
					}
				}
				
			}
			
		};
		
		discordLink.addMouseListener(ml);
		youtubeLink.addMouseListener(ml);
	}
	
	public static void getVersion() {
		BotMClient client = new BotMClient("botmserver.ddnss.de", 7921);
		client.setMuted(true);
		Datapackage result = client.sendMessage(new Datapackage("GET_NEWEST_VERSION"));
		int newestVersionId = (int) result.get(1);
		
		if(newestVersionId > versionId) {
			JOptionPane.showMessageDialog(frame, "Eine neue Version ist verfügbar!");
		}
	}
	
	public class ButtonClickListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == creditsButton) {
				credits.setVisible(true);
				screenshots.setVisible(false);
				news.setVisible(false);
				discord.setVisible(false);
				discordLink.setVisible(false);
				youtube.setVisible(false);
				youtubeLink.setVisible(false);
			} else if(e.getSource() == screenshotsButton) {
				credits.setVisible(false);
				screenshots.setVisible(true);
				news.setVisible(false);
				discord.setVisible(false);
				discordLink.setVisible(false);
				youtube.setVisible(false);
				youtubeLink.setVisible(false);
				
				BotMClient client = new BotMClient("botmserver.ddnss.de", 7921);
				client.setMuted(true);
				if(client.isServerReachable()) {
					Datapackage result = client.sendMessage(new Datapackage("FETCH_SCREENSHOTS"));
					String fileName = "BreathOfTheMinecraftAppScreenshots.jpg";
					
					File file = new File(fileName);
					Datapackage byteDatapackage = (Datapackage) result.get(1);
					byte[] bytes = (byte[]) byteDatapackage.get(1);
					
					System.out.println(bytes);
					
					try (FileOutputStream writer = new FileOutputStream(file)) {
						writer.write(bytes);
					} catch (IOException ex) {
						ex.printStackTrace();
					}
					
					screenshots.setIcon(new ImageIcon("BreathOfTheMinecraftAppScreenshots.jpg"));
					screenshots.setText(null);
				} else {
					screenshots.setIcon(null);
					screenshots.setText("An error occured whilst trying to fetch current screenshots.");
				}
			} else if(e.getSource() == newsButton) {
				credits.setVisible(false);
				screenshots.setVisible(false);
				news.setVisible(true);
				discord.setVisible(false);
				discordLink.setVisible(false);
				youtube.setVisible(false);
				youtubeLink.setVisible(false);
				
				BotMClient client = new BotMClient("botmserver.ddnss.de", 7921);
				client.setMuted(true);
				if(client.isServerReachable()) {
					Datapackage result = client.sendMessage(new Datapackage("FETCH_NEWS"));
					
					Datapackage newsDatapackage = (Datapackage) result.get(1);
					String newsText = (String) newsDatapackage.get(1);
					
					news.setText(newsText);
				} else {
					news.setText("An error occured whilst trying to fetch current news.");
				}
			} else if(e.getSource() == discordButton) {
				credits.setVisible(false);
				screenshots.setVisible(false);
				news.setVisible(false);
				discord.setVisible(true);
				discordLink.setVisible(true);
				youtube.setVisible(false);
				youtubeLink.setVisible(false);
			} else if(e.getSource() == youtubeButton) {
				credits.setVisible(false);
				screenshots.setVisible(false);
				news.setVisible(false);
				discord.setVisible(false);
				discordLink.setVisible(false);
				youtube.setVisible(true);
				youtubeLink.setVisible(true);
			} else if(e.getSource() == codeButton) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/NitramMann21/BreathOfTheMinecraftApp"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			} else if(e.getSource() == downloadsButton) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/NitramMann21/BreathOfTheMinecraftApp/releases"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			} else if(e.getSource() == forumButton) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/NitramMann21/BreathOfTheMinecraftApp/issues"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			} else if(e.getSource() == wikiButton) {
				try {
					Desktop.getDesktop().browse(new URI("https://github.com/NitramMann21/BreathOfTheMinecraftApp/wiki"));
				} catch (IOException | URISyntaxException ex) {
					ex.printStackTrace();
				}
			}
		}
		
	}
	
}

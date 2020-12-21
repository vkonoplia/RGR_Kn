package test;


import java.awt.EventQueue;
import java.awt.FileDialog;
import java.util.Enumeration;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeModel;

import model.AnyData;
import model.Player;
import model.Olympiad;
import model.Sport;
import model.Country;

import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;


public class GUI extends JFrame {

	private JFrame frame;
	private JPanel contentPane;
	private JTree tree;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setTitle("Konoplia");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 436, 411);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmStore = new JMenuItem("Store");
		mntmStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onStore();
			}
		});
		mnFile.add(mntmStore);
		
		JMenuItem mntmRestore = new JMenuItem("Restore");
		mntmRestore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onRestore();
			}
		});
		mnFile.add(mntmRestore);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmTz = new JMenuItem("T\u0417");
		mntmTz.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickTz();
			}
		});
		mnAbout.add(mntmTz);
		
		JMenuItem mntmDiagram = new JMenuItem("Diagram");
		mntmDiagram.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onClickDiagram();
			}
		});
		mnAbout.add(mntmDiagram);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onAdd();
			}
		});
		btnAdd.setBounds(12, 13, 122, 33);
		contentPane.add(btnAdd);
		
		JButton btnRemove = new JButton("Remove");
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onRemove();
			}
		});
		btnRemove.setBounds(12, 59, 122, 33);
		contentPane.add(btnRemove);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onEdit();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(tree);
		btnEdit.setBounds(12, 105, 122, 33);
		contentPane.add(btnEdit);
		scrollPane.setBounds(183, 13, 221, 314);
		contentPane.add(scrollPane);
		
		tree = new JTree();
		scrollPane.setColumnHeaderView(tree);
		tree.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				onMouseClicked(arg0);
			}
		});
		
		
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(12, 151, 122, 33);
		contentPane.add(btnCalculate);
		
		JPopupMenu popupMenu = new JPopupMenu();
		addPopup(btnCalculate, popupMenu);
		
		JButton btnSearch = new JButton("Search player with greatest award");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				onSearch();
			}
		});
		popupMenu.add(btnSearch);
		
		JButton btnCount = new JButton("Count the number of player");
		btnCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				onCount();
			}
		});
		popupMenu.add(btnCount);
		
		onWindowOpened();
	}
	
	protected void onCount() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = getSelectNode();
		if(node == null)
			return;
		int count = 0;	
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> enm = 
				node.postorderEnumeration();
		while(enm.hasMoreElements()) {
			DefaultMutableTreeNode currentNode = enm.nextElement();
			Object data = currentNode.getUserObject();
			if(!(data instanceof Player))
				continue;
			count++;
		}
			JOptionPane.showMessageDialog(tree, "number of player: " + count);
			
		}


	protected void onClickDiagram() {
		// TODO Auto-generated method stub
		DlgDiagram dlgDm = new DlgDiagram();
		dlgDm.setLocationRelativeTo(frame);
		dlgDm.setVisible(true);
		dlgDm.dispose();
	}

	protected void onClickTz() {
		// TODO Auto-generated method stub
		DlgTz dlgTz = new DlgTz();
		dlgTz.setLocationRelativeTo(frame);
		dlgTz.setVisible(true);
		dlgTz.dispose();
	}

	protected void onSearch() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = getSelectNode();
		if(node == null)
			return;
		int maxAward = 0;
		DefaultMutableTreeNode oldest = null;
		
		@SuppressWarnings("unchecked")
		Enumeration<DefaultMutableTreeNode> enm = 
				node.postorderEnumeration();
		while(enm.hasMoreElements()) {
			DefaultMutableTreeNode currentNode = enm.nextElement();
			Object data = currentNode.getUserObject();
			if(!(data instanceof Player))
				continue;
			int award = ((Player) data).getCountAward();
			if(award > maxAward) {
				maxAward = award;
				oldest = currentNode;
			}
		}
		System.out.println(oldest);
		selectNode(oldest);
		((AnyData) oldest.getUserObject()).showDialog(false);
		}
		


	protected void onRestore() {
		// TODO Auto-generated method stub
		FileDialog fileDialog = new FileDialog(frame);
		fileDialog.setMode(fileDialog.LOAD);
		fileDialog.setVisible(true);
		String dr = fileDialog.getDirectory();
		String fn = fileDialog.getFile();
		if(dr == null || fn == null) 
			return;
		String fName  = dr + fn;
		try {
			ObjectInputStream in = new ObjectInputStream(
					new FileInputStream(fName));
			TreeModel model = (TreeModel) in.readObject();
			tree.setModel(model);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(tree,
					"Помилка десеріалізації дерева",
					"Десеріалізація",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		expandAll();
	}

	protected void onStore() {
		// TODO Auto-generated method stub
		if(tree.getModel() == null) return;
		JFileChooser fileChooser = 
				new JFileChooser("Серіалізація моделі дерева");
		fileChooser.showSaveDialog(frame);
		try {
			File f = fileChooser.getSelectedFile();
			String fName = f.getAbsolutePath();
			FileOutputStream fileStream =
					new FileOutputStream(fName);
			ObjectOutputStream out = 
					new ObjectOutputStream(fileStream);
			out.writeObject(tree.getModel());
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(tree, 
					"Помилка відкриття файлу",
					"Збереження дерева у файлі",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		tree.setModel((new JTree()).getModel());
	}

	protected void onEdit() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = getSelectNode();
		if(node == null) return;
		AnyData data = (AnyData) node.getUserObject();
		Dlg dlg = data.showDialog(true);
		Object obj;
		try {
			obj = dlg.createObject();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(tree, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		((JDialog) dlg).dispose();
		if(obj == null) return;
		node.setUserObject(obj);
		
		tree.updateUI();
	}

	protected void onRemove() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode node = getSelectNode();
		if(node == null)
			return;
		
		node.removeFromParent();
		
		tree.setSelectionPath(null);
		tree.updateUI();
	}

	protected void onAdd() {
		// TODO Auto-generated method stub
		DefaultMutableTreeNode parent = getSelectNode();
		if(parent == null) return;
		
		AnyData parentData = (AnyData) parent.getUserObject();
		Dlg dlg = parentData.showSonDlialog();
		if(dlg == null) return;
		Object obj;
		try {
			obj = dlg.createObject();
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(tree, e.getMessage(),
					"Error", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		((JDialog) dlg).dispose();
		if(obj == null)
			return;
		
		DefaultMutableTreeNode newSon = new DefaultMutableTreeNode(obj);
		parent.add(newSon);
		tree.updateUI();
		expandAll();
	}

	protected void onMouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getClickCount() != 3 || e.getButton() != MouseEvent.BUTTON3)
			return;
		DefaultMutableTreeNode node = getSelectNode();
		if(node == null)
			return;
		AnyData data = (AnyData) node.getUserObject();
		Dlg dlg = data.showDialog(false);
		((JDialog) dlg).dispose();
	}

	public JTree getTree() {
		return tree;
	}
	
	protected TreeModel getStartModel() throws Exception{
		Olympiad Olympiad = new Olympiad("Євро 2020", 2020, "Україна", 20);
		Country country = new Country("Китай", 15, 7, 4, 3);
		Sport sport = new Sport("Волейбол", 1988, true, false);
		Player player = new Player("Іванов І.І.", 1990, 1);
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(Olympiad);
		DefaultMutableTreeNode fNod = new DefaultMutableTreeNode(country);
		DefaultMutableTreeNode dNod = new DefaultMutableTreeNode(sport);
		DefaultMutableTreeNode tNod = new DefaultMutableTreeNode(player);
		
		root.add(fNod); fNod.add(dNod); dNod.add(tNod);
		
		return (new JTree(root).getModel());
	}
	
	protected void onWindowOpened() {
		try {
			tree.setModel(getStartModel());
			
			for(int i = 0 ; i < tree.getRowCount(); i++) {
				tree.expandRow(i);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	private DefaultMutableTreeNode getSelectNode() {
		
		Object selectNode = tree.getLastSelectedPathComponent();
		if(selectNode == null) {
			JOptionPane.showMessageDialog(tree, "Node was not selected","Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
		
		return (DefaultMutableTreeNode) selectNode;
	}
	
	private void expandAll() {
		for(int i = 0; i< tree.getRowCount(); i++) {
			tree.expandRow(i);
		}
	}
	
	private void selectNode(DefaultMutableTreeNode node) {
		int n = 0;
		DefaultMutableTreeNode root = 
				(DefaultMutableTreeNode) tree.getModel().getRoot();
		Enumeration<DefaultMutableTreeNode> enm = root.children();
		while(enm.hasMoreElements()) {
			DefaultMutableTreeNode nod = enm.nextElement();
			if(nod == node) {
				tree.setSelectionRow(n);
				return;
			}
			n++;
		}
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

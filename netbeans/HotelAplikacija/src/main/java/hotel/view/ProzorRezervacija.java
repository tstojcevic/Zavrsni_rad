/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package hotel.view;

import com.github.lgooddatepicker.components.DatePickerSettings;
import hotel.controller.ObradaGost;
import hotel.controller.ObradaRezervacija;
import hotel.controller.ObradaSmjestaj;
import hotel.model.Djelatnik;
import hotel.model.Gost;
import hotel.model.Rezervacija;
import hotel.model.Smjestaj;
import hotel.util.Aplikacija;
import hotel.util.HotelException;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Korisnik
 */
public class ProzorRezervacija extends javax.swing.JFrame implements HotelViewSucelje {

    private ObradaRezervacija obrada;
    private ObradaSmjestaj obradaSmjestaj;
    private DecimalFormat df;
    private SimpleDateFormat sdf;

    /**
     * Creates new form ProzorRezervacija
     */
    public ProzorRezervacija() {
        initComponents();
        obrada = new ObradaRezervacija();
        obradaSmjestaj = new ObradaSmjestaj();
        sdf = new SimpleDateFormat("dd.MM.YYYY", new Locale("hr","HR"));
        DecimalFormatSymbols dfs = new DecimalFormatSymbols(new Locale("hr", "HR"));
        df = new DecimalFormat("###,##0.00",dfs);
        
        setTitle(Aplikacija.NAZIV_APP + ": "
                + Aplikacija.OPERATER.getImePrezime()
                + ": Rezervacije");
        definirajDatumPrijave();
        definirajDatumOdjave();
        ucitajFilterGosti();
        ucitajGoste();
        ucitaj();
    }

    private void definirajDatumPrijave() {
        DatePickerSettings dps
                = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumPrijave.setSettings(dps);
    }

    private void definirajDatumOdjave() {
        DatePickerSettings dps
                = new DatePickerSettings(new Locale("hr", "HR"));
        dps.setFormatForDatesCommonEra("dd. MM. YYYY.");
        dps.setTranslationClear("Očisti");
        dps.setTranslationToday("Danas");
        dpDatumOdjave.setSettings(dps);
    }

    private void ucitajGoste() {
        DefaultComboBoxModel<Gost> m = new DefaultComboBoxModel<>();
        Gost g = new Gost();
        g.setSifra(0);
        g.setIme("Nije");
        g.setPrezime(" odabrano");
        m.addElement(g);
        m.addAll(new ObradaGost().read());
        cmbGost.setModel(m);
        cmbGost.repaint();
    }

    private void ucitajFilterGosti() {
        DefaultComboBoxModel<Gost> m = new DefaultComboBoxModel<>();
        m.addAll(new ObradaGost().read());
        cmbFilterGosti.setModel(m);
        cmbFilterGosti.repaint();
        cmbFilterGosti.setSelectedIndex(0);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbFilterGosti = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPodaci = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        txtBrojRezervacije = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtBrojGostiju = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtBrojSmjestajnihJedinica = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbGost = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        dpDatumPrijave = new com.github.lgooddatepicker.components.DatePicker();
        jLabel6 = new javax.swing.JLabel();
        dpDatumOdjave = new com.github.lgooddatepicker.components.DatePicker();
        btnDodaj = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstSmjestajiNaRezervaciji = new javax.swing.JList<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstSmjestajiUBazi = new javax.swing.JList<>();
        txtUvjet2 = new javax.swing.JTextField();
        btnTrazi = new javax.swing.JButton();
        btnDodajPolaznika = new javax.swing.JButton();
        btnObrisiPolaznika = new javax.swing.JButton();
        btnPromijeni = new javax.swing.JButton();
        btnObriši = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        cmbFilterGosti.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbFilterGostiItemStateChanged(evt);
            }
        });

        lstPodaci.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        lstPodaci.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPodaciValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPodaci);

        jLabel1.setText("Broj rezervacije");

        jLabel2.setText("Broj gostiju");

        jLabel3.setText("Broj smještajnih jedinica");

        jLabel4.setText("Gost");

        jLabel5.setText("Datum prijave");

        jLabel6.setText("Datum odjave");

        btnDodaj.setText("Dodaj");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jLabel7.setText("Smještaji na rezervaciji");

        jScrollPane2.setViewportView(lstSmjestajiNaRezervaciji);

        jLabel8.setText("Smještaji u bazi");

        jScrollPane3.setViewportView(lstSmjestajiUBazi);

        txtUvjet2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUvjet2ActionPerformed(evt);
            }
        });
        txtUvjet2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUvjet2KeyPressed(evt);
            }
        });

        btnTrazi.setText("🔍");
        btnTrazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraziActionPerformed(evt);
            }
        });

        btnDodajPolaznika.setText("<<");
        btnDodajPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPolaznikaActionPerformed(evt);
            }
        });

        btnObrisiPolaznika.setText(">>");
        btnObrisiPolaznika.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiPolaznikaActionPerformed(evt);
            }
        });

        btnPromijeni.setText("Promijeni");
        btnPromijeni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPromijeniActionPerformed(evt);
            }
        });

        btnObriši.setText("Obriši");
        btnObriši.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrišiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmbFilterGosti, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1)
                                        .addComponent(txtBrojRezervacije)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtBrojGostiju)
                                        .addComponent(jLabel3)
                                        .addComponent(txtBrojSmjestajnihJedinica)
                                        .addComponent(jLabel4)
                                        .addComponent(cmbGost, 0, 146, Short.MAX_VALUE))
                                    .addComponent(jLabel5)
                                    .addComponent(dpDatumPrijave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dpDatumOdjave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(36, 36, 36))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnObriši, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(11, 11, 11)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnDodajPolaznika, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnObrisiPolaznika, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDodaj)
                        .addGap(18, 18, 18)
                        .addComponent(btnPromijeni)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnTrazi, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(txtBrojRezervacije, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBrojGostiju, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtBrojSmjestajnihJedinica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmbGost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dpDatumPrijave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dpDatumOdjave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnDodaj)
                                    .addComponent(btnPromijeni))
                                .addGap(9, 9, 9)
                                .addComponent(btnObriši))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtUvjet2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnTrazi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnDodajPolaznika)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnObrisiPolaznika)
                                        .addGap(133, 133, 133))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbFilterGosti, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFilterGostiItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbFilterGostiItemStateChanged
        ucitaj();
    }//GEN-LAST:event_cmbFilterGostiItemStateChanged

    private void lstPodaciValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPodaciValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstPodaci.getSelectedValue() == null) {
            return;
        }

        obrada.setEntitet(lstPodaci.getSelectedValue());

        napuniView();
    }//GEN-LAST:event_lstPodaciValueChanged

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        obrada.setEntitet(new Rezervacija());
        napuniModel();
        try {
            obrada.create();
            ucitaj();
        } catch (HotelException ex) {
            JOptionPane.showMessageDialog(getParent(), ex.getPoruka());
        }
    }//GEN-LAST:event_btnDodajActionPerformed

    private void txtUvjet2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUvjet2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUvjet2ActionPerformed

    private void txtUvjet2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUvjet2KeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            ucitajSmjestaje();
        }
    }//GEN-LAST:event_txtUvjet2KeyPressed

    private void btnTraziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraziActionPerformed
        ucitajSmjestaje();
    }//GEN-LAST:event_btnTraziActionPerformed

    private void btnDodajPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPolaznikaActionPerformed

        if(lstSmjestajiUBazi.getSelectedValuesList()==null
            || lstSmjestajiUBazi.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                "Prvo pronađite smještaj/e");
            return;
        }

        if(lstSmjestajiNaRezervaciji.getModel()==null ||
            !(lstSmjestajiNaRezervaciji.getModel() instanceof DefaultListModel<Smjestaj>)){
            lstSmjestajiNaRezervaciji.setModel(new DefaultListModel<Smjestaj>());
        }

        DefaultListModel<Smjestaj> m =
        (DefaultListModel<Smjestaj>) lstSmjestajiNaRezervaciji.getModel();

        DefaultListModel<Smjestaj> smjestaji =
        (DefaultListModel<Smjestaj>) lstSmjestajiNaRezervaciji.getModel();
        boolean postoji;
        for(Smjestaj sub : lstSmjestajiUBazi.getSelectedValuesList()){
            postoji=false;
            for(int i=0;i<smjestaji.getSize();i++){
                if(sub.getSifra()==smjestaji.get(i).getSifra()){
                    postoji=true;
                    break;
                }
            }
            if(!postoji){
                smjestaji.addElement(sub);
            }
        }
        lstSmjestajiNaRezervaciji.repaint();

    }//GEN-LAST:event_btnDodajPolaznikaActionPerformed

    private void btnObrisiPolaznikaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiPolaznikaActionPerformed
        if(lstSmjestajiNaRezervaciji.getSelectedValuesList()==null
            || lstSmjestajiNaRezervaciji.getSelectedValuesList().isEmpty()){
            JOptionPane.showMessageDialog(getRootPane(),
                "Prvo odaberite smještaj u rezervaciji");
            return;
        }

        DefaultListModel<Smjestaj> m =
        (DefaultListModel<Smjestaj>) lstSmjestajiNaRezervaciji.getModel();

        for(Smjestaj s : lstSmjestajiNaRezervaciji.getSelectedValuesList()){
            m.removeElement(s);
        }
        lstSmjestajiNaRezervaciji.repaint();

    }//GEN-LAST:event_btnObrisiPolaznikaActionPerformed

    private void btnPromijeniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPromijeniActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(getRootPane(),
                "Prvo odaberite rezervaciju");
            return;
        }

        napuniModel();
        try {
            obrada.update();
            ucitaj();
        } catch (HotelException ex) {
            JOptionPane.showMessageDialog(getRootPane(),
                ex.getPoruka());
        }
    }//GEN-LAST:event_btnPromijeniActionPerformed

    private void btnObrišiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrišiActionPerformed
        if(lstPodaci.getSelectedValue()==null){
            JOptionPane.showMessageDialog(
                getRootPane(),
                "Prvo odaberite rezervaciju");
            return;
        }

        if(JOptionPane.showConfirmDialog(
            getRootPane(),
            "Sigurno obrisati " + obrada.getEntitet().getBrojRezervacije() + "?",
            "Brisanje",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE)==JOptionPane.NO_OPTION){
        return;
        }

        try {
            obrada.delete();
            ucitaj();
        } catch (HotelException ex) {
            JOptionPane.showMessageDialog(
                getRootPane(),
                ex.getPoruka());
        }

    }//GEN-LAST:event_btnObrišiActionPerformed

    
    private void ucitajSmjestaje(){
        DefaultListModel<Smjestaj> m = new DefaultListModel<>();
        m.addAll(obradaSmjestaj.read(txtUvjet2.getText().trim()));
        lstSmjestajiUBazi.setModel(m);
        lstSmjestajiUBazi.repaint();
    }
    
    @Override
    public void ucitaj() {
        DefaultListModel<Rezervacija> m = new DefaultListModel<>();
        m.addAll(obrada.read((Gost) cmbFilterGosti.getSelectedItem()));
        lstPodaci.setModel(m);
        lstPodaci.repaint();
    }

    @Override
    public void napuniView() {
        var e = obrada.getEntitet();
        txtBrojRezervacije.setText(e.getBrojRezervacije());
        try {
            txtBrojGostiju.setText(String.valueOf(e.getBrojGostiju()));
        } catch (Exception ex) {
            txtBrojGostiju.setText("");
        }
        try {
            txtBrojSmjestajnihJedinica.setText(String.valueOf(e.getBrojSmjestajnihJedinica()));
        } catch (Exception ex) {
            txtBrojSmjestajnihJedinica.setText("");
        }
        cmbGost.setSelectedItem(e.getGost());
        
        if(e.getDatumPrijave()!=null){
             LocalDate ld = e.getDatumPrijave()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        dpDatumPrijave.setDate(ld);
        }else{
            dpDatumPrijave.setDate(null);
        }
        
        if(e.getDatumOdjave()!=null){
             LocalDate ld = e.getDatumOdjave()
                .toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
        dpDatumOdjave.setDate(ld);
        }else{
            dpDatumOdjave.setDate(null);
        }
        
        DefaultListModel<Smjestaj> m = new DefaultListModel<>();
        if(e.getSmjestaji()!=null && !e.getSmjestaji().isEmpty()){
            m.addAll(e.getSmjestaji());
        }
        lstSmjestajiNaRezervaciji.setModel(m);
        lstSmjestajiNaRezervaciji.repaint();

    }

    @Override
    public void napuniModel() {
        var e = obrada.getEntitet();
        e.setBrojRezervacije(txtBrojRezervacije.getText());
        try {
            e.setBrojGostiju(Integer.parseInt(txtBrojGostiju.getText()));
        } catch (Exception ex) {
            e.setBrojGostiju(0);
        }
        try {
            e.setBrojSmjestajnihJedinica(Integer.parseInt(txtBrojSmjestajnihJedinica.getText()));
        } catch (Exception ex) {
            e.setBrojSmjestajnihJedinica(0);
        }
        e.setGost((Gost) cmbGost.getSelectedItem());
        e.setDatumPrijave(dpDatumPrijave.getDate()!=null?
                            Date.from(dpDatumPrijave.getDate()
                            .atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant())
                            : null);
        e.setDatumOdjave(dpDatumOdjave.getDate()!=null?
                            Date.from(dpDatumOdjave.getDate()
                            .atStartOfDay()
                            .atZone(ZoneId.systemDefault())
                            .toInstant())
                            : null);
        
        List<Smjestaj> smjestaji = new ArrayList<>();
        try {
            DefaultListModel<Smjestaj> m = (DefaultListModel<Smjestaj>) lstSmjestajiNaRezervaciji.getModel();
            for(int i=0;i<m.getSize();i++){
                smjestaji.add(m.getElementAt(i));
            }
        } catch (Exception ex) {
        }
        e.setSmjestaji(smjestaji);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnDodajPolaznika;
    private javax.swing.JButton btnObrisiPolaznika;
    private javax.swing.JButton btnObriši;
    private javax.swing.JButton btnPromijeni;
    private javax.swing.JButton btnTrazi;
    private javax.swing.JComboBox<Gost> cmbFilterGosti;
    private javax.swing.JComboBox<Gost> cmbGost;
    private com.github.lgooddatepicker.components.DatePicker dpDatumOdjave;
    private com.github.lgooddatepicker.components.DatePicker dpDatumPrijave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<Rezervacija> lstPodaci;
    private javax.swing.JList<Smjestaj> lstSmjestajiNaRezervaciji;
    private javax.swing.JList<Smjestaj> lstSmjestajiUBazi;
    private javax.swing.JTextField txtBrojGostiju;
    private javax.swing.JTextField txtBrojRezervacije;
    private javax.swing.JTextField txtBrojSmjestajnihJedinica;
    private javax.swing.JTextField txtUvjet;
    private javax.swing.JTextField txtUvjet1;
    private javax.swing.JTextField txtUvjet2;
    // End of variables declaration//GEN-END:variables
}

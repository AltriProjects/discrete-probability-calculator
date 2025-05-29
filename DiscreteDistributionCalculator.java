import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Discrete Probability Distributions Calculator
 * 
 * @author Atri (github.com/AtriProjects)
 * @course ITA 225 - Probability and Statistics in Information Technology
 * @date May 29, 2025
 * @version 0.3-alpha
 */
public class DiscreteDistributionCalculator extends JFrame {

    // ==================== GUI COMPONENTS ====================
    private JComboBox<String> distributionComboBox;
    private JPanel parameterPanel;
    private JPanel resultPanel;
    private JTextArea resultArea;
    private DecimalFormat df = new DecimalFormat("0.######");

    // ==================== COLOR SCHEME ====================
    private static final Color PRIMARY_COLOR = new Color(99, 102, 241); // Indigo
    private static final Color PRIMARY_DARK = new Color(79, 70, 229); // Darker indigo
    private static final Color SECONDARY_COLOR = new Color(16, 185, 129); // Emerald
    private static final Color DANGER_COLOR = new Color(239, 68, 68); // Red
    private static final Color BACKGROUND_COLOR = new Color(249, 250, 251); // Light gray
    private static final Color CARD_COLOR = Color.WHITE; // White
    private static final Color TEXT_PRIMARY = new Color(17, 24, 39); // Dark gray
    private static final Color TEXT_SECONDARY = new Color(107, 114, 128); // Medium gray
    private static final Color BORDER_COLOR = new Color(229, 231, 235); // Light border

    // ==================== INPUT COMPONENTS ====================
    private JTextField nField, pField, kField, lambdaField, NField, KField;
    private JLabel nLabel, pLabel, kLabel, lambdaLabel, NLabel, KLabel;

    public DiscreteDistributionCalculator() {
        setTitle("Discrete Probability Calculator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(0, 0));
        setSize(900, 700);
        setLocationRelativeTo(null); // Center on screen
        setBackground(BACKGROUND_COLOR);

        try {
            UIManager.put("Button.arc", 8);
            UIManager.put("Component.arc", 8);
            UIManager.put("TextComponent.arc", 8);
        } catch (Exception e) {
            // Ignore if not supported by the current Look and Feel
        }

        initializeComponents();
        setupLayout();
        setVisible(true);
    }

    private void initializeComponents() {
        String[] distributions = { "Binomial Distribution", "Poisson Distribution",
                "Geometric Distribution", "Hypergeometric Distribution" };
        distributionComboBox = new JComboBox<>(distributions);
        distributionComboBox.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        distributionComboBox.setPreferredSize(new Dimension(220, 40));
        distributionComboBox.setBackground(CARD_COLOR);
        distributionComboBox.setBorder(new LineBorder(BORDER_COLOR, 1));
        distributionComboBox.addActionListener(e -> updateParameterPanel());

        parameterPanel = new JPanel(new GridBagLayout());
        parameterPanel.setBackground(CARD_COLOR);
        parameterPanel.setBorder(createModernCard("Parameters"));

        nField = createModernTextField();
        pField = createModernTextField();
        kField = createModernTextField();
        lambdaField = createModernTextField();
        NField = createModernTextField();
        KField = createModernTextField();

        nLabel = createModernLabel("n (number of trials)");
        pLabel = createModernLabel("p (probability of success)");
        kLabel = createModernLabel("k (number of successes)");
        lambdaLabel = createModernLabel("λ (average rate)");
        NLabel = createModernLabel("N (population size)");
        KLabel = createModernLabel("K (success states in population)");

        resultPanel = new JPanel(new BorderLayout(0, 15));
        resultPanel.setBackground(CARD_COLOR);
        resultPanel.setBorder(createModernCard("Results"));

        resultArea = new JTextArea(20, 50);
        resultArea.setFont(new Font("JetBrains Mono", Font.PLAIN, 13));
        resultArea.setBackground(new Color(248, 250, 252));
        resultArea.setForeground(TEXT_PRIMARY);
        resultArea.setEditable(false);
        resultArea.setBorder(new EmptyBorder(15, 15, 15, 15));
        resultArea.setLineWrap(false);

        JScrollPane scrollPane = new JScrollPane(resultArea);
        scrollPane.setBorder(new LineBorder(BORDER_COLOR, 1));
        scrollPane.setBackground(CARD_COLOR);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getViewport().setBackground(new Color(248, 250, 252));
        resultPanel.add(scrollPane, BorderLayout.CENTER);

        updateParameterPanel();
    }

    private JTextField createModernTextField() {
        JTextField field = new JTextField(15);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setPreferredSize(new Dimension(250, 35));
        field.setBorder(new CompoundBorder(
                new LineBorder(BORDER_COLOR, 1),
                new EmptyBorder(5, 10, 5, 10)));
        field.setBackground(Color.WHITE);
        field.setForeground(TEXT_PRIMARY);
        field.setCaretColor(TEXT_PRIMARY);
        field.setSelectionColor(new Color(99, 102, 241, 50));
        field.setSelectedTextColor(TEXT_PRIMARY);
        return field;
    }

    private JLabel createModernLabel(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        label.setForeground(TEXT_PRIMARY);
        label.setBorder(new EmptyBorder(0, 0, 5, 0));
        return label;
    }

    private CompoundBorder createModernCard(String title) {
        TitledBorder titledBorder = new TitledBorder(title);
        titledBorder.setTitleFont(new Font("Segoe UI", Font.BOLD, 16));
        titledBorder.setTitleColor(TEXT_PRIMARY);
        titledBorder.setBorder(new LineBorder(BORDER_COLOR, 1));

        return new CompoundBorder(
                titledBorder,
                new EmptyBorder(20, 20, 20, 20));
    }

    private void setupLayout() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(CARD_COLOR);
        headerPanel.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 1, 0, BORDER_COLOR),
                new EmptyBorder(25, 30, 25, 30)));

        JLabel titleLabel = new JLabel("Discrete Probability Calculator");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(TEXT_PRIMARY);

        JPanel selectionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 5));
        selectionPanel.setBackground(CARD_COLOR);

        JLabel selectLabel = new JLabel("Distribution Type:");
        selectLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        selectLabel.setForeground(TEXT_SECONDARY);
        selectLabel.setBorder(new EmptyBorder(0, 0, 0, 10));

        selectionPanel.add(selectLabel);
        selectionPanel.add(distributionComboBox);

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(selectionPanel, BorderLayout.EAST);

        JButton calculateButton = createModernButton("Calculate", PRIMARY_COLOR, PRIMARY_DARK);
        calculateButton.addActionListener(new CalculateActionListener());

        JButton clearButton = createModernButton("Clear", DANGER_COLOR, new Color(220, 38, 38));
        clearButton.addActionListener(e -> {
            resultArea.setText("");
            clearParameterFields();
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.setBackground(CARD_COLOR);
        buttonPanel.setBorder(new EmptyBorder(0, 0, 10, 0));
        buttonPanel.add(calculateButton);
        buttonPanel.add(clearButton);

        JPanel leftPanel = new JPanel(new BorderLayout(0, 20));
        leftPanel.setBackground(BACKGROUND_COLOR);
        leftPanel.setBorder(new EmptyBorder(20, 20, 20, 10));
        leftPanel.add(parameterPanel, BorderLayout.CENTER);
        leftPanel.add(buttonPanel, BorderLayout.SOUTH);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setBackground(BACKGROUND_COLOR);
        rightPanel.setBorder(new EmptyBorder(20, 10, 20, 20));
        rightPanel.add(resultPanel, BorderLayout.CENTER);

        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBackground(BACKGROUND_COLOR);
        contentPanel.add(leftPanel, BorderLayout.WEST);
        contentPanel.add(rightPanel, BorderLayout.CENTER);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private JButton createModernButton(String text, Color bgColor, Color hoverColor) {
        JButton button = new JButton(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                if (getModel().isPressed()) {
                    g2.setColor(hoverColor.darker());
                } else if (getModel().isRollover()) {
                    g2.setColor(hoverColor);
                } else {
                    g2.setColor(bgColor);
                }

                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 8, 8);

                g2.setColor(Color.WHITE);
                g2.setFont(getFont());
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(getText())) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(getText(), x, y);

                g2.dispose();
            }
        };

        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setPreferredSize(new Dimension(120, 42));
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return button;
    }

    private void updateParameterPanel() {
        parameterPanel.removeAll();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        String selectedDistribution = (String) distributionComboBox.getSelectedItem();

        if (selectedDistribution.startsWith("Binomial")) {
            addParameterRow(gbc, 0, nLabel, nField);
            addParameterRow(gbc, 1, pLabel, pField);
            addParameterRow(gbc, 2, kLabel, kField);
        } else if (selectedDistribution.startsWith("Poisson")) {
            addParameterRow(gbc, 0, lambdaLabel, lambdaField);
            addParameterRow(gbc, 1, kLabel, kField);
        } else if (selectedDistribution.startsWith("Geometric")) {
            addParameterRow(gbc, 0, pLabel, pField);
            addParameterRow(gbc, 1, kLabel, kField);
        } else if (selectedDistribution.startsWith("Hypergeometric")) {
            addParameterRow(gbc, 0, NLabel, NField);
            addParameterRow(gbc, 1, KLabel, KField);
            addParameterRow(gbc, 2, nLabel, nField);
            addParameterRow(gbc, 3, kLabel, kField);
        }

        parameterPanel.revalidate();
        parameterPanel.repaint();
        clearParameterFields();
    }

    private void addParameterRow(GridBagConstraints gbc, int row, JLabel label, JTextField field) {
        gbc.gridx = 0;
        gbc.gridy = row * 2;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 5, 0);
        gbc.anchor = GridBagConstraints.WEST;
        parameterPanel.add(label, gbc);

        gbc.gridx = 0;
        gbc.gridy = row * 2 + 1;
        gbc.gridwidth = 1;
        gbc.insets = new Insets(0, 0, 15, 0);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        parameterPanel.add(field, gbc);
    }

    private void clearParameterFields() {
        nField.setText("");
        pField.setText("");
        kField.setText("");
        lambdaField.setText("");
        NField.setText("");
        KField.setText("");
    }

    private class CalculateActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String selectedDistribution = (String) distributionComboBox.getSelectedItem();
                StringBuilder result = new StringBuilder();

                if (selectedDistribution.startsWith("Binomial")) {
                    calculateBinomial(result);
                } else if (selectedDistribution.startsWith("Poisson")) {
                    calculatePoisson(result);
                } else if (selectedDistribution.startsWith("Geometric")) {
                    calculateGeometric(result);
                } else if (selectedDistribution.startsWith("Hypergeometric")) {
                    calculateHypergeometric(result);
                }

                resultArea.setText(result.toString());
                resultArea.setCaretPosition(0);
            } catch (Exception ex) {
                showModernErrorDialog("Error: " + ex.getMessage());
            }
        }
    }

    private void showModernErrorDialog(String message) {
        JOptionPane optionPane = new JOptionPane(message, JOptionPane.ERROR_MESSAGE);
        optionPane.setBackground(CARD_COLOR);
        JDialog dialog = optionPane.createDialog(this, "Input Error");
        dialog.setVisible(true);
    }

    // ==================== CALCULATION METHODS ====================
    private void calculateBinomial(StringBuilder result) throws Exception {
        int n = Integer.parseInt(nField.getText().trim());
        double p = Double.parseDouble(pField.getText().trim());
        int k = Integer.parseInt(kField.getText().trim());

        if (n <= 0 || p < 0 || p > 1 || k < 0 || k > n) {
            throw new Exception("Invalid parameters for Binomial distribution");
        }

        result.append("📊 BINOMIAL DISTRIBUTION\n");
        result.append("════════════════════════════════════════════════════════\n\n");
        result.append("📋 Parameters:\n");
        result.append("   • n (trials) = ").append(n).append("\n");
        result.append("   • p (probability) = ").append(df.format(p)).append("\n");
        result.append("   • k (successes) = ").append(k).append("\n\n");

        double pmf = binomialPMF(n, k, p);
        double cdf = binomialCDF(n, k, p);
        double mean = n * p;
        double variance = n * p * (1 - p);

        result.append("🎯 Probability Results:\n");
        result.append("   • P(X = ").append(k).append(") = ").append(df.format(pmf)).append("\n");
        result.append("   • P(X ≤ ").append(k).append(") = ").append(df.format(cdf)).append("\n");
        result.append("   • P(X > ").append(k).append(") = ").append(df.format(1 - cdf)).append("\n\n");

        result.append("📈 Statistical Measures:\n");
        result.append("   • Expected Value (μ) = ").append(df.format(mean)).append("\n");
        result.append("   • Variance (σ²) = ").append(df.format(variance)).append("\n");
        result.append("   • Standard Deviation (σ) = ").append(df.format(Math.sqrt(variance))).append("\n");
    }

    private void calculatePoisson(StringBuilder result) throws Exception {
        double lambda = Double.parseDouble(lambdaField.getText().trim());
        int k = Integer.parseInt(kField.getText().trim());

        if (lambda <= 0 || k < 0) {
            throw new Exception("Invalid parameters for Poisson distribution");
        }

        result.append("📊 POISSON DISTRIBUTION\n");
        result.append("════════════════════════════════════════════════════════\n\n");
        result.append("📋 Parameters:\n");
        result.append("   • λ (rate) = ").append(df.format(lambda)).append("\n");
        result.append("   • k (events) = ").append(k).append("\n\n");

        double pmf = poissonPMF(lambda, k);
        double cdf = poissonCDF(lambda, k);

        result.append("🎯 Probability Results:\n");
        result.append("   • P(X = ").append(k).append(") = ").append(df.format(pmf)).append("\n");
        result.append("   • P(X ≤ ").append(k).append(") = ").append(df.format(cdf)).append("\n");
        result.append("   • P(X > ").append(k).append(") = ").append(df.format(1 - cdf)).append("\n\n");

        result.append("📈 Statistical Measures:\n");
        result.append("   • Expected Value (μ) = ").append(df.format(lambda)).append("\n");
        result.append("   • Variance (σ²) = ").append(df.format(lambda)).append("\n");
        result.append("   • Standard Deviation (σ) = ").append(df.format(Math.sqrt(lambda))).append("\n");
    }

    private void calculateGeometric(StringBuilder result) throws Exception {
        double p = Double.parseDouble(pField.getText().trim());
        int k = Integer.parseInt(kField.getText().trim());

        if (p <= 0 || p > 1 || k <= 0) {
            throw new Exception("Invalid parameters for Geometric distribution");
        }

        result.append("📊 GEOMETRIC DISTRIBUTION\n");
        result.append("════════════════════════════════════════════════════════\n\n");
        result.append("📋 Parameters:\n");
        result.append("   • p (probability) = ").append(df.format(p)).append("\n");
        result.append("   • k (trial of first success) = ").append(k).append("\n\n");

        double pmf = geometricPMF(p, k);
        double cdf = geometricCDF(p, k);
        double mean = 1.0 / p;
        double variance = (1 - p) / (p * p);

        result.append("🎯 Probability Results:\n");
        result.append("   • P(X = ").append(k).append(") = ").append(df.format(pmf)).append("\n");
        result.append("   • P(X ≤ ").append(k).append(") = ").append(df.format(cdf)).append("\n");
        result.append("   • P(X > ").append(k).append(") = ").append(df.format(1 - cdf)).append("\n\n");

        result.append("📈 Statistical Measures:\n");
        result.append("   • Expected Value (μ) = ").append(df.format(mean)).append("\n");
        result.append("   • Variance (σ²) = ").append(df.format(variance)).append("\n");
        result.append("   • Standard Deviation (σ) = ").append(df.format(Math.sqrt(variance))).append("\n");
    }

    private void calculateHypergeometric(StringBuilder result) throws Exception {
        int N = Integer.parseInt(NField.getText().trim());
        int K = Integer.parseInt(KField.getText().trim());
        int n = Integer.parseInt(nField.getText().trim());
        int k = Integer.parseInt(kField.getText().trim());

        if (N <= 0 || K < 0 || K > N || n <= 0 || n > N || k < 0 || k > Math.min(n, K)) {
            throw new Exception("Invalid parameters for Hypergeometric distribution");
        }

        result.append("📊 HYPERGEOMETRIC DISTRIBUTION\n");
        result.append("════════════════════════════════════════════════════════\n\n");
        result.append("📋 Parameters:\n");
        result.append("   • N (population size) = ").append(N).append("\n");
        result.append("   • K (success states in population) = ").append(K).append("\n");
        result.append("   • n (draws) = ").append(n).append("\n");
        result.append("   • k (observed successes) = ").append(k).append("\n\n");

        double pmf = hypergeometricPMF(N, K, n, k);
        double cdf = hypergeometricCDF(N, K, n, k);
        double mean = (double) n * K / N;
        double variance = (double) n * (K / (double) N) * (1 - K / (double) N) * (N - n) / (N - 1);

        result.append("🎯 Probability Results:\n");
        result.append("   • P(X = ").append(k).append(") = ").append(df.format(pmf)).append("\n");
        result.append("   • P(X ≤ ").append(k).append(") = ").append(df.format(cdf)).append("\n");
        result.append("   • P(X > ").append(k).append(") = ").append(df.format(1 - cdf)).append("\n\n");

        result.append("📈 Statistical Measures:\n");
        result.append("   • Expected Value (μ) = ").append(df.format(mean)).append("\n");
        result.append("   • Variance (σ²) = ").append(df.format(variance)).append("\n");
        result.append("   • Standard Deviation (σ) = ").append(df.format(Math.sqrt(variance))).append("\n");
    }

    // ==================== MATH UTILITY METHODS ====================
    private double binomialPMF(int n, int k, double p) {
        return combination(n, k) * Math.pow(p, k) * Math.pow(1 - p, n - k);
    }

    private double binomialCDF(int n, int k, double p) {
        double sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += binomialPMF(n, i, p);
        }
        return sum;
    }

    private double poissonPMF(double lambda, int k) {
        return Math.exp(-lambda) * Math.pow(lambda, k) / factorial(k);
    }

    private double poissonCDF(double lambda, int k) {
        double sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += poissonPMF(lambda, i);
        }
        return sum;
    }

    private double geometricPMF(double p, int k) {
        return Math.pow(1 - p, k - 1) * p;
    }

    private double geometricCDF(double p, int k) {
        return 1 - Math.pow(1 - p, k);
    }

    private double hypergeometricPMF(int N, int K, int n, int k) {
        return (double) combination(K, k) * combination(N - K, n - k) / combination(N, n);
    }

    private double hypergeometricCDF(int N, int K, int n, int k) {
        double sum = 0;
        for (int i = 0; i <= k; i++) {
            sum += hypergeometricPMF(N, K, n, i);
        }
        return sum;
    }

    private long factorial(int n) {
        if (n <= 1)
            return 1;
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    private long combination(int n, int r) {
        if (r > n || r < 0)
            return 0;
        if (r == 0 || r == n)
            return 1;

        r = Math.min(r, n - r); // Take advantage of symmetry
        long result = 1;
        for (int i = 0; i < r; i++) {
            result = result * (n - i) / (i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new DiscreteDistributionCalculator();
        });
    }
}
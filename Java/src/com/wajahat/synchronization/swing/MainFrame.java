package com.wajahat.synchronization.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainFrame extends JFrame {

    private JLabel counter = new JLabel("0");
    private JLabel statusLabel = new JLabel("Task not completed");
    private JButton start = new JButton("Start");
    private JButton stop = new JButton("Stop");
    SwingWorker<Boolean, Integer> worker;

    public MainFrame(String title) {
        super(title);

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.NONE;

        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        add(counter, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        gc.weightx = 1;
        gc.weighty = 1;
        add(statusLabel, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(start, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.weightx = 1;
        gc.weighty = 1;
        add(stop, gc);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                start();
            }
        });

        stop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                stop();
            }
        });

        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void start() {
        System.out.println("Start");
        statusLabel.setText("Started");
        worker = new SwingWorker<Boolean, Integer>() {

            @Override
            protected Boolean doInBackground() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Interrupted!");
                        break;
                    }
                    publish(i);
                }
                return true;
            }

            @Override
            protected void process(List<Integer> chunks) {
                Integer value = chunks.get(chunks.size() - 1);
                counter.setText(value.toString());
            }

            @Override
            protected void done() {
                try {
                    Boolean status = get();
                    statusLabel.setText("Completed");
                    System.out.println("Completed with status: " + status);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        };
        worker.execute();
    }

    private void stop() {
        System.out.println("Stop");
        statusLabel.setText("Stopped");
        if (worker != null && !worker.isCancelled()) {
            worker.cancel(true);
        }
        counter.setText("0");
    }
}

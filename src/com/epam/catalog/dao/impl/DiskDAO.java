package com.epam.catalog.dao.impl;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.catalog.bean.Disk;
import com.epam.catalog.bean.News;
import com.epam.catalog.bean.genre.MusicGenre;
import com.epam.catalog.dao.DAOException;
import com.epam.catalog.dao.NewsDAO;

public class DiskDAO implements NewsDAO{
	
	private static final Logger LOG = LogManager.getRootLogger();
	private static final String DISK_FILE ="D:/Projects/Catalog/Disk.txt";
	
	@Override
	public ArrayList<? extends News> findAll() throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Disk> disks = new ArrayList<Disk>();
        
        try {
			reader = new FileReader(DISK_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Disk disk;
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				disk = new Disk(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],MusicGenre.valueOf(parts[4]));
				disks.add(disk);
				
			}
		} catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
		return disks;
	}

	@Override
	public ArrayList<? extends News> findBy(String type, String value) throws DAOException {
		FileReader reader = null;
        BufferedReader br = null;
        ArrayList<Disk> disks = new ArrayList<Disk>();
        
        try {
        	reader = new FileReader(DISK_FILE);
			br = new BufferedReader(reader);
			String s;
			String [] parts;
			Disk disk;
			int i = Type.numberOfEnum(type);
			while ((s = br.readLine()) != null) {
				parts = s.split("@");
				if (parts[i].equalsIgnoreCase(value)) {
					disk = new Disk(parts[0],parts[1],Integer.parseInt(parts[2]),parts[3],MusicGenre.valueOf(parts[4]));
					disks.add(disk);
				}
			}
			
        }catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				reader.close();
				br.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
		return disks;
	}

	@Override
	public void addNews(News news) throws DAOException {
		
		if (!(news instanceof Disk)) {
			LOG.error("Incorrect type of news");
			throw new DAOException("Incorrect type of news");
		}
		
		Disk disk = (Disk) news;
		FileWriter writer = null;
		
        try {
            writer = new FileWriter(DISK_FILE, true);
            writer.write(disk.getTitle()+"@"+disk.getAuthor()+"@"+disk.getYear()+"@"+disk.getText()+"@"+disk.getGenre());
            writer.append("\r\n");
        } catch (FileNotFoundException e) {
			LOG.error(e);
			throw new DAOException("Book file is not found", e);
		} catch (IOException e) {
			LOG.error(e);
			throw new DAOException(e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				LOG.error(e);
			}
		}
	}
}

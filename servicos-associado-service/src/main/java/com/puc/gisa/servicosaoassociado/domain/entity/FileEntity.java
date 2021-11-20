package com.puc.gisa.servicosaoassociado.domain.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter 
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="documents")
public class FileEntity extends AbstractEntity {
	
	@Column(name = "flow_name")
	@NotNull @NotEmpty
    private String flowName;
	
    @Column(name = "file_name")
    @NotNull @NotEmpty
    private String fileName;
    
    @Column(name = "file_type")
    @NotNull @NotEmpty
    private String fileType;
    
    @Temporal(TemporalType.DATE)
	@Column(name = "log_data", length = 10)
    @NotNull
	private Date logData;
    
    @Lob
    private byte[] data;
    
}

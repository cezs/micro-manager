package org.micromanager.data;

import org.micromanager.MultiStagePosition;
import org.micromanager.PropertyMap;

/**
 * This class defines the summary metadata that applies to all images in a
 * dataset. It is immutable; construct it with a SummaryMetadataBuilder. All
 * fields of the SummaryMetadata that are not explicitly initialized will
 * default to null. You are not expected to implement this interface; it is here
 * to describe how you can interact with SummaryMetadata created by
 * Micro-Manager itself. If you need to create a new SummaryMetadata, either use
 * the getSummaryMetadataBuilder() method of the DataManager class, or call the
 * copy() method of an existing SummaryMetadata instance.
 */
public interface SummaryMetadata {

   interface SummaryMetadataBuilder {

      /**
       * Construct a SummaryMetadata from the SummaryMetadataBuilder. Call this
       * once you are finished setting all SummaryMetadata parameters.
       *
       * @return object containing summary metadata
       */
      SummaryMetadata build();

      // The following functions each set the relevant value for the 
      // SummaryMetadata. See the corresponding getter methods of
      // SummaryMetadata, below, for the meaning of these properties.
      SummaryMetadataBuilder fileName(String fileName);

      SummaryMetadataBuilder prefix(String prefix);

      SummaryMetadataBuilder userName(String userName);

      SummaryMetadataBuilder profileName(String profileName);

      SummaryMetadataBuilder microManagerVersion(String microManagerVersion);

      SummaryMetadataBuilder metadataVersion(String metadataVersion);

      SummaryMetadataBuilder computerName(String computerName);

      SummaryMetadataBuilder directory(String directory);

      SummaryMetadataBuilder comments(String comments);

      SummaryMetadataBuilder channelNames(String[] channelNames);

      SummaryMetadataBuilder zStepUm(Double zStepUm);

      SummaryMetadataBuilder waitInterval(Double waitInterval);

      SummaryMetadataBuilder customIntervalsMs(Double[] customIntervalsMs);

      SummaryMetadataBuilder intendedDimensions(Coords intendedDimensions);

      SummaryMetadataBuilder startDate(String startDate);

      SummaryMetadataBuilder stagePositions(MultiStagePosition[] stagePositions);

      SummaryMetadataBuilder userData(PropertyMap userData);
   }

   /**
    * Generate a new SummaryMetadataBuilder whose values are initialized to be
    * the values of this SummaryMetadata.
    * @return new SummaryMetadataBuilder whose values are initialized to be
    * the values of this SummaryMetadata
    */
   SummaryMetadataBuilder copy();

   /**
    * The complete filename for this file, including any suffix attached by
    * Micro-Manager
    * @return complete filename for this file, including any suffix attached by
    * Micro-Manager
    */
   public String getFileName();

   /**
    * The user-supplied portion of the filename, not including Micro-Manager's
    * additional suffix
    * @return user-supplied portion of the filename, not including Micro-Manager's
    * additional suffix
    */
   public String getPrefix();

   /**
    * The signed-in user of the machine that collected this data
    * @return signed-in user of the machine that collected this data
    */
   public String getUserName();

   /**
    * The name of the Micro-Manager profile used to collect this data.
    * @return name of the micro-Manager profile used to collect this data
    */
   public String getProfileName();

   /**
    * The version of Micro-Manager used to collect the data
    * @return version of Micro-Manager used to collect the data
    */
   public String getMicroManagerVersion();

   /**
    * The version of the metadata when the data was collected
    * @return version of the metadata when the data was collected
    */
   public String getMetadataVersion();

   /**
    * The name of the computer the data was collected on
    * @return name of the computer the data was collected on
    */
   public String getComputerName();

   /**
    * The directory the data was originally saved to
    * @return directory the data was originally saved to
    */
   public String getDirectory();

   /**
    * Any comments attached to the acquisition as a whole (not to individual
    * images within the acquisition)
    * @return Any comments attached to the acquisition as a whole
    */
   public String getComments();

   /**
    * Array of names of channels
    * @return names of Channels
    */
   public String[] getChannelNames();

   /**
    * Distance between slices in a volume of data, in microns
    * @return distance between slices in a volume of data, in microns
    */
   public Double getZStepUm();

   /**
    * Amount of time to wait between timepoints
    * @return amount of time to wait between timepoints
    */
   public Double getWaitInterval();

   /**
    * When using a variable amount of time between timepoints, this array has
    * the list of wait times
    * @return list of wait times between timepoints
    */
   public Double[] getCustomIntervalsMs();

   /**
    * The expected number of images along each axis that were to be collected.
    * The actual dimensions may differ if the acquisition was aborted partway
    * through for any reason.
    * @return expected number of images along each axis that were to be collected
    */
   public Coords getIntendedDimensions();

   /**
    * The date and time at which the acquisition started
    * @return date and time at which the acquisition started
    */
   public String getStartDate();

   /**
    * The stage positions that were to be visited in the acquisition
    * @return stage positions that were to be visited in the acquisition
    */
   public MultiStagePosition[] getStagePositions();

   /**
    * Any general-purpose user meta data
    *
    * @return Any general-purpose user meta data
    */
   public PropertyMap getUserData();
}

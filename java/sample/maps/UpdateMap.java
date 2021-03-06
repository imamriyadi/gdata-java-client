/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package sample.maps;

import com.google.gdata.client.*;
import com.google.gdata.client.maps.*;
import com.google.gdata.data.*;
import com.google.gdata.data.maps.*;
import com.google.gdata.util.*;
import java.io.IOException;
import java.net.URL;

public class UpdateMap {
  
  public static void main(String[] args) {
    MapsService myService = new MapsService("updateMap");
    try {
     // Replace username and password with your authentication credentials
      myService.setUserCredentials("username","password");
      updateMap(myService);
    } catch(AuthenticationException e) {
      System.out.println("Authentication Exception");
    } catch(ServiceException e) {
      System.out.println("Service Exception: " + e.getMessage());
    } catch(IOException e) {
      System.out.println("I/O Exception");
    }
  }

  public static MapEntry updateMap(MapsService myService)
    throws ServiceException, IOException {

    // Use the map entry's post (edit) URL
	// Replace userID and mapID with appropriate values for your map
    final URL editMapUrl = new URL("http://maps.google.com/maps/feeds/maps/userID/full/mapID");
 
    // Create a MapEntry object and replace the title to 'Demo Map 2'
    MapEntry myEntry = new MapEntry();
    myEntry.setTitle(new PlainTextConstruct("Demo Map 2"));
    return myService.update(editMapUrl, myEntry);
  }
}
